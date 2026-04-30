package co.com.accenture.r2dbc.product;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query("""
    SELECT DISTINCT ON (branch_id) p.*
    FROM products p
    WHERE p.branch_id IN (
        SELECT id FROM branches WHERE franchise_id = :franchiseId
    )
    ORDER BY branch_id, stock DESC
""")
    Flux<ProductData> findTopStockPerBranchByFranchiseId(@Param("franchiseId") UUID franchiseId);
}