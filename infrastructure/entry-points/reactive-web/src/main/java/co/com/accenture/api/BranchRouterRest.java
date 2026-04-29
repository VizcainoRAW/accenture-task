package co.com.accenture.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class BranchRouterRest {

    @Bean
    public RouterFunction<ServerResponse> BranchRoutes(BranchHandler handler) {
        return route()
                .nest(path("/api/branch"), builder -> builder
                        .POST("/", handler::create)
                        .GET("/", handler::findAll)
//                        .PATCH("/{id}/name", handler::updateName)
//                        .GET("/{id}/top-stock", handler::getTopStockByBranch)
                )
                .build();
    }
}