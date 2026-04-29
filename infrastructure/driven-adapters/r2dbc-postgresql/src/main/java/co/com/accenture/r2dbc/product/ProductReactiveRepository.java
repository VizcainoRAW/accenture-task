package co.com.accenture.r2dbc.product;

import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface ProductReactiveRepository extends
        ReactiveCrudRepository<ProductData, UUID>,
        ReactiveQueryByExampleExecutor<ProductData> {

    Flux<ProductData> findAllByBranchId(String branchId);
    Mono<ProductData> findTopByBranchIdOrderByStockDesc(String branchId);
}