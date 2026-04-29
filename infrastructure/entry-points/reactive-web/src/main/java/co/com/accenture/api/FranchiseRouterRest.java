package co.com.accenture.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class FranchiseRouterRest {

    @Bean
    public RouterFunction<ServerResponse> franchiseRoutes(FranchiseHandler handler) {
        return route()
                .nest(path("/api/franchise"), builder -> builder
                        .POST("/", handler::create)
                        .GET("/", handler::findAll)
                        .GET("/{id}", handler::findById)
//                        .PATCH("/{id}/name", handler::updateName)
//                        .GET("/{id}/top-stock", handler::getTopStockByFranchise)
                )
                .build();
    }
}