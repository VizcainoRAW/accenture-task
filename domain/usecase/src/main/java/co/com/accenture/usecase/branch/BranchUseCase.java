package co.com.accenture.usecase.branch;

import co.com.accenture.model.branch.Branch;
import co.com.accenture.model.branch.gateways.BranchRepository;
import co.com.accenture.model.exception.ResourceNotFoundException;
import co.com.accenture.model.franchise.gateways.FranchiseRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class BranchUseCase {

    private final BranchRepository branchRepository;
    private final FranchiseRepository franchiseRepository;

    Flux<Branch> findAll(){
        return branchRepository.findAll();
    }

    Flux<Branch> findAllByFranchiseId(String franchiseId){
        return branchRepository.findAllByFranchiseId(franchiseId);
    }

    public Mono<Branch> create(Branch branch) {
        return franchiseRepository.existsById(branch.getFranchiseId())
                .flatMap(exists -> !exists
                        ? Mono.error(new ResourceNotFoundException("Franquicia no encontrada"))
                        : branchRepository.save(branch)
                );
    }

}
