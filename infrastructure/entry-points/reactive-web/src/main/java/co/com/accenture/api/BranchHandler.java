package co.com.accenture.api;

import co.com.accenture.api.dto.BranchRequestDTO;
import co.com.accenture.model.franchise.Franchise;
import co.com.accenture.usecase.branch.BranchUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class BranchHandler {

    private final BranchUseCase BranchUseCase;
    private final BranchMapper mapper;

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ServerResponse
                .ok()
                .body(BranchUseCase.findAll(), Franchise.class);
    }

    public Mono<ServerResponse> create(ServerRequest request) {
        return request.bodyToMono(BranchRequestDTO.class)
                .map(mapper::toModel)
                .flatMap(BranchUseCase::create)
                .map(mapper::toDTO)
                .flatMap(dto -> ServerResponse.status(201).bodyValue(dto));
    }

}