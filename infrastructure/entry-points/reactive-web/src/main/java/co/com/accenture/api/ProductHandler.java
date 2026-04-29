package co.com.accenture.api;

import co.com.accenture.api.dto.ProductRequestDTO;

import co.com.accenture.model.product.Product;
import co.com.accenture.usecase.product.ProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ProductHandler {

    private final ProductUseCase productUseCase;
    private final ProductMapper mapper;

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ServerResponse
                .ok()
                .body(productUseCase.findAll(), Product.class);
    }

    public Mono<ServerResponse> create(ServerRequest request) {
        return request.bodyToMono(ProductRequestDTO.class)
                .map(mapper::toModel)
                .doOnNext(Product -> System.out.println("Product to be saved: " + Product))
                .flatMap(productUseCase::create)
                .map(mapper::toDTO)
                .flatMap(dto -> ServerResponse.status(201).bodyValue(dto));
    }


    public Mono<ServerResponse> delete(ServerRequest request) {
        String id = request.pathVariable("id");
        return productUseCase.delete(id)
                .then(ServerResponse.ok().build());
    }

}