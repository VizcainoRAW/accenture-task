package co.com.accenture.api;

import co.com.accenture.model.franchise.Franchise;
import co.com.accenture.usecase.franchise.FranchiseUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class FranchiseHandler {

    private final FranchiseUseCase franchiseUseCase;

    public Mono<ServerResponse> findById(ServerRequest request) {
        String id = request.pathVariable("id");
        return franchiseUseCase.findById(id)
                .flatMap(franchise -> ServerResponse
                        .ok()
                        .bodyValue(franchise));
    }

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ServerResponse
                .ok()
                .body(franchiseUseCase.findAll(), Franchise.class);
    }

}