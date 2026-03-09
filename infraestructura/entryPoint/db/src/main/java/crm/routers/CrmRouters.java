package crm.routers;

import crm.handlers.ActivityHandler;
import crm.handlers.ContactHandler;
import crm.handlers.OpportunityHandler;
import crm.handlers.TenantHandler;
import crm.handlers.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class CrmRouters {

    @Bean
    public RouterFunction<ServerResponse> tenantRoutes(TenantHandler handler) {
        return route(POST("/api/tenants"), handler::create)
                .andRoute(GET("/api/tenants"), handler::getAll)
                .andRoute(GET("/api/tenants/{id}"), handler::getById);
    }

    @Bean
    public RouterFunction<ServerResponse> userRoutes(UserHandler handler) {
        return route(POST("/api/users"), handler::create)
                .andRoute(GET("/api/users"), handler::getAll)
                .andRoute(GET("/api/users/{id}"), handler::getById);
    }

    @Bean
    public RouterFunction<ServerResponse> contactRoutes(ContactHandler handler) {
        return route(POST("/api/contacts"), handler::create)
                .andRoute(GET("/api/contacts"), handler::getAll)
                .andRoute(GET("/api/contacts/{id}"), handler::getById);
    }

    @Bean
    public RouterFunction<ServerResponse> opportunityRoutes(OpportunityHandler handler) {
        return route(POST("/api/opportunities"), handler::create)
                .andRoute(GET("/api/opportunities"), handler::getAll)
                .andRoute(GET("/api/opportunities/{id}"), handler::getById);
    }

    @Bean
    public RouterFunction<ServerResponse> activityRoutes(ActivityHandler handler) {
        return route(POST("/api/activities"), handler::create)
                .andRoute(GET("/api/activities"), handler::getAll)
                .andRoute(GET("/api/activities/{id}"), handler::getById);
    }
}
