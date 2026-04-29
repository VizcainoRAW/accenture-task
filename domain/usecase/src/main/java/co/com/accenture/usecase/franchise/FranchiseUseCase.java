package co.com.accenture.usecase.franchise;

import co.com.accenture.model.franchise.Franchise;
import co.com.accenture.model.franchise.gateways.FranchiseRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class FranchiseUseCase {

    private final FranchiseRepository franchiseRepository;

    public Mono<Franchise> findById(String id) {
        return franchiseRepository.findById(id);
    }

    public Mono<Franchise> save(Franchise franchise) {
        return franchiseRepository.save(franchise);
    }

    public Mono<Void> deleteById(String id) {
        return franchiseRepository.deleteById(id);
    }

    public Mono<Boolean> existsById(String id) {
        return franchiseRepository.existsById(id);
    }

    public Flux<Franchise> findAll() { return franchiseRepository.findAll(); }


}
