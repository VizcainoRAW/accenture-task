package co.com.accenture.r2dbc.branch;

import co.com.accenture.model.branch.Branch;
import co.com.accenture.model.branch.gateways.BranchRepository;
import co.com.accenture.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public class BranchRepositoryAdapter extends ReactiveAdapterOperations
                <Branch,
                BranchData,
                        UUID,
                BranchReactiveRepository>
        implements BranchRepository {

    public BranchRepositoryAdapter(BranchReactiveRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, Branch.BranchBuilder.class).build());
    }

    @Override
    public Mono<Branch> save(Branch branch) {
        return repository.save(
                BranchData.builder()
                        .id(null)
                        .name(branch.getName())
                        .franchiseId(UUID.fromString(branch.getFranchiseId()))
                        .build()
        ).map(this::toEntity);
    }

    @Override
    public Flux<Branch> findAllByFranchiseId(String franchiseId) {
        return repository.findAllByFranchiseId(franchiseId)
                .map(this::toEntity);
    }

    @Override
    public Mono<Branch> findById(String id) {
        return repository.findById(UUID.fromString(id)).map(this::toEntity);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return repository.deleteById(UUID.fromString(id));
    }

    @Override
    public Mono<Boolean> existsById(String id) {
        if (id == null) {
            return Mono.just(false);
        }
        return repository.existsById(UUID.fromString(id));
    }
}