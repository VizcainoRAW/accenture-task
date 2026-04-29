package co.com.accenture.r2dbc.franchise;

import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface FranchiseReactiveRepository extends
        ReactiveCrudRepository<FranchiseData, UUID>,
        ReactiveQueryByExampleExecutor<FranchiseData> {
}