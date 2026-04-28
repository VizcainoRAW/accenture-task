package co.com.accenture.usecase.product;

import co.com.accenture.model.branch.gateways.BranchRepository;
import co.com.accenture.model.exception.ResourceNotFoundException;
import co.com.accenture.model.product.Product;
import co.com.accenture.model.product.gateways.ProductRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ProductUseCase {

    private final ProductRepository productRepository;
    private final BranchRepository branchRepository;

    public Mono<Product> create(Product product) {
        return branchRepository.existsById(product.getBranchId())
                .flatMap(exists -> !exists
                        ? Mono.error(new ResourceNotFoundException("Sucursal no encontrada"))
                        : productRepository.save(product)
                );
    }

    public Mono<Void> delete(String id) {
        return productRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("Producto no encontrado")))
                .flatMap(product -> productRepository.deleteById(id));
    }

    public Mono<Product> updateStock(String id, Integer stock) {
        return productRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("Producto no encontrado")))
                .flatMap(existing -> productRepository.updateStock(id, stock));
    }

    public Mono<Product> updateName(String id, String name) {
        return productRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("Producto no encontrado")))
                .flatMap(existing -> productRepository.save(
                        existing.toBuilder().name(name).build()
                ));
    }
}
