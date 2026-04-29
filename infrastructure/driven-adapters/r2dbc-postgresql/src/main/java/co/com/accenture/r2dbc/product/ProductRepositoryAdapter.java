package co.com.accenture.r2dbc.product;

import co.com.accenture.model.product.Product;
import co.com.accenture.model.product.gateways.ProductRepository;
import co.com.accenture.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public class ProductRepositoryAdapter extends ReactiveAdapterOperations
                <Product,
                ProductData,
                UUID,
                ProductReactiveRepository>
        implements ProductRepository {

    public ProductRepositoryAdapter(ProductReactiveRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, Product.ProductBuilder.class).build());
    }

    public Mono<Product> save(Product product) {
        return repository.save(ProductData.builder()
                .id(null)
                .name(product.getName())
                .stock(product.getStock())
                .branchId(UUID.fromString(product.getBranchId()))
                .build())
                .map(this::toEntity);
    }

    @Override
    public Flux<Product> findAllByBranchId(String branchId) {
        return repository.findAllByBranchId(branchId)
                .map(this::toEntity);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return repository.deleteById(UUID.fromString(id));
    }

    @Override
    public Mono<Boolean> existsById(String id) {
        return repository.existsById(UUID.fromString(id));
    }

    @Override
    public Mono<Product> findById(String id) {
        return repository.findById(UUID.fromString(id))
                .map(this::toEntity);
    }

    @Override
    public Mono<Product> updateStock(String id, Integer stock) {
        return repository.findById(UUID.fromString(id))
                .flatMap(data -> repository.save(
                        data.toBuilder().stock(stock).build()
                ))
                .map(this::toEntity);
    }
}