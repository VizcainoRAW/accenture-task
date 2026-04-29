package co.com.accenture.r2dbc.franchise;

import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface FranchiseReactiveRepository extends
        ReactiveCrudRepository<FranchiseData, String>,
        ReactiveQueryByExampleExecutor<FranchiseData> {
}