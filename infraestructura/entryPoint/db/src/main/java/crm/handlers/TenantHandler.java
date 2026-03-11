package crm.handlers;

import domain.entities.models.Tenant;
import domain.ports.TenantGateway;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
public class TenantHandler {

    private final TenantGateway gateway;

    public TenantHandler(TenantGateway gateway) {
        this.gateway = gateway;
    }

    public Mono<ServerResponse> create(ServerRequest request) {
        return request.bodyToMono(Tenant.class)
                .flatMap(gateway::save)
                .flatMap(tenant -> ServerResponse.created(URI.create("/api/tenants/" + tenant.getId()))
                        .bodyValue(tenant));
    }

    public Mono<ServerResponse> getById(ServerRequest request) {
        String id = request.pathVariable("id");
        return gateway.findById(id)
                .flatMap(tenant -> ServerResponse.ok().bodyValue(tenant))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> getAll(ServerRequest request) {
        return ServerResponse.ok().body(gateway.findAll(), Tenant.class);
    }
}
