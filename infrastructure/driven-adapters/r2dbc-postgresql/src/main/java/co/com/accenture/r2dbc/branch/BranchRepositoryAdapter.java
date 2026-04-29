package co.com.accenture.r2dbc.branch;

import co.com.accenture.model.branch.Branch;
import co.com.accenture.model.branch.gateways.BranchRepository;
import co.com.accenture.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class BranchRepositoryAdapter extends ReactiveAdapterOperations
                <Branch,
                BranchData,
                String,
                BranchReactiveRepository>
        implements BranchRepository {

    public BranchRepositoryAdapter(BranchReactiveRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, Branch.BranchBuilder.class).build());
    }

    @Override
    public Flux<Branch> findAllByFranchiseId(String franchiseId) {
        return repository.findAllByFranchiseId(franchiseId)
                .map(this::toEntity);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return repository.deleteById(id);
    }

    @Override
    public Mono<Boolean> existsById(String id) {
        return repository.existsById(id);
    }
}