package co.com.accenture.r2dbc.franchise;

import co.com.accenture.model.franchise.Franchise;
import co.com.accenture.model.franchise.gateways.FranchiseRepository;
import co.com.accenture.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class FranchiseRepositoryAdapter extends ReactiveAdapterOperations <Franchise,
                FranchiseData,
                String,
                FranchiseReactiveRepository>
        implements FranchiseRepository {

    public FranchiseRepositoryAdapter(FranchiseReactiveRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, Franchise.FranchiseBuilder.class).build());
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