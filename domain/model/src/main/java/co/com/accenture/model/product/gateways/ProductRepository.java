package co.com.accenture.model.product.gateways;

import co.com.accenture.model.branch.Branch;
import co.com.accenture.model.product.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepository {

    Flux<Product> findAll();

    Flux<Product> findAllByBranchId(String branchId);

    Mono<Branch> save(Product product);

    Mono<Void> deleteById(String id);

    Mono<Boolean> existsById(String id);

    Mono<Product> findById(String id);

}
