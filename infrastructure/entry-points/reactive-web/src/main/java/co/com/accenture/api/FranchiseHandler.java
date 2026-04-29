package co.com.accenture.api;

import co.com.accenture.api.dto.FranchiseRequestDTO;
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
    private final FranchiseMapper mapper;

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

    public Mono<ServerResponse> create(ServerRequest request) {
        return request.bodyToMono(FranchiseRequestDTO.class)
                .map(mapper::toModel)
                .doOnNext(franchise -> System.out.println("Franchise to be saved: " + franchise))
                .flatMap(franchiseUseCase::save)
                .map(mapper::toDTO)
                .flatMap(dto -> ServerResponse.status(201).bodyValue(dto));
    }

}