package co.com.accenture.model.franchise.gateways;

import co.com.accenture.model.franchise.Franchise;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FranchiseRepository {

    Flux<Franchise> findAll();

    Mono<Franchise> findById(String id);

    Mono<Franchise> save(Franchise f);

    Mono<Void> deleteById(String id);

    Mono<Boolean> existsById(String id);

}
