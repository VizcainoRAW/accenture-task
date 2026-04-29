package co.com.accenture.r2dbc.branch;

import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface BranchReactiveRepository extends
        ReactiveCrudRepository<BranchData, String>,
        ReactiveQueryByExampleExecutor<BranchData> {

    Flux<BranchData> findAllByFranchiseId(String franchiseId);
}