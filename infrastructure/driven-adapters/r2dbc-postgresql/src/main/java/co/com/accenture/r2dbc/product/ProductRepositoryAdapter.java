package co.com.accenture.r2dbc.product;

import co.com.accenture.model.product.Product;
import co.com.accenture.model.product.gateways.ProductRepository;
import co.com.accenture.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class ProductRepositoryAdapter extends ReactiveAdapterOperations
                <Product,
                ProductData,
                String,
                ProductReactiveRepository>
        implements ProductRepository {

    public ProductRepositoryAdapter(ProductReactiveRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, Product.ProductBuilder.class).build());
    }

    @Override
    public Flux<Product> findAllByBranchId(String branchId) {
        return repository.findAllByBranchId(branchId)
                .map(this::toEntity);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return null;
    }

    @Override
    public Mono<Boolean> existsById(String id) {
        return repository.existsById(id);
    }

    @Override
    public Mono<Product> updateStock(String id, Integer stock) {
        return repository.findById(id)
                .flatMap(data -> repository.save(
                        data.toBuilder().stock(stock).build()
                ))
                .map(this::toEntity);
    }
}