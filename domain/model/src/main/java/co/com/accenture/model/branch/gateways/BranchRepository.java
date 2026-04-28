package co.com.accenture.model.branch.gateways;

import co.com.accenture.model.branch.Branch;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BranchRepository {

    Flux<Branch> findAll();

    Mono<Branch> findById(String id);

    Mono<Branch> save(Branch f);

    Mono<Void> deleteById(String id);

    Mono<Boolean> existsById(String id);

    Flux<Branch> findAllByFranchiseId(String franchiseId);
}
