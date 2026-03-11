package crm.handlers;

import domain.entities.models.Opportunity;
import domain.ports.OpportunityGateway;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
public class OpportunityHandler {

    private final OpportunityGateway gateway;

    public OpportunityHandler(OpportunityGateway gateway) {
        this.gateway = gateway;
    }

    public Mono<ServerResponse> create(ServerRequest request) {
        String tenantId = request.headers().firstHeader("X-Tenant-Id");

        return request.bodyToMono(Opportunity.class)
                .map(opportunity -> {
                    if (tenantId != null)
                        opportunity.setTenantId(tenantId);
                    return opportunity;
                })
                .flatMap(gateway::save)
                .flatMap(opportunity -> ServerResponse.created(URI.create("/api/opportunities/" + opportunity.getId()))
                        .bodyValue(opportunity));
    }

    public Mono<ServerResponse> getById(ServerRequest request) {
        String id = request.pathVariable("id");
        String tenantId = request.headers().firstHeader("X-Tenant-Id");

        if (tenantId == null)
            return ServerResponse.badRequest().build();

        return gateway.findById(id, tenantId)
                .flatMap(opportunity -> ServerResponse.ok().bodyValue(opportunity))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> getAll(ServerRequest request) {
        String tenantId = request.headers().firstHeader("X-Tenant-Id");

        if (tenantId == null)
            return ServerResponse.badRequest().build();

        return ServerResponse.ok().body(gateway.findAllByTenantId(tenantId), Opportunity.class);
    }
}
