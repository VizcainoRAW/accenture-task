package co.com.accenture.r2dbc.branch;

import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface BranchReactiveRepository extends
        ReactiveCrudRepository<BranchData, UUID>,
        ReactiveQueryByExampleExecutor<BranchData> {

    Flux<BranchData> findAllByFranchiseId(String franchiseId);
}