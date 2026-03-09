package crm.handlers;

import domain.entities.models.Activity;
import domain.entities.models.gateways.ActivityGateway;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
public class ActivityHandler {

    private final ActivityGateway gateway;

    public ActivityHandler(ActivityGateway gateway) {
        this.gateway = gateway;
    }

    public Mono<ServerResponse> create(ServerRequest request) {
        String tenantId = request.headers().firstHeader("X-Tenant-Id");

        return request.bodyToMono(Activity.class)
                .map(activity -> {
                    if (tenantId != null)
                        activity.setTenantId(tenantId);
                    return activity;
                })
                .flatMap(gateway::save)
                .flatMap(activity -> ServerResponse.created(URI.create("/api/activities/" + activity.getId()))
                        .bodyValue(activity));
    }

    public Mono<ServerResponse> getById(ServerRequest request) {
        String id = request.pathVariable("id");
        String tenantId = request.headers().firstHeader("X-Tenant-Id");

        if (tenantId == null)
            return ServerResponse.badRequest().build();

        return gateway.findById(id, tenantId)
                .flatMap(activity -> ServerResponse.ok().bodyValue(activity))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> getAll(ServerRequest request) {
        String tenantId = request.headers().firstHeader("X-Tenant-Id");

        if (tenantId == null)
            return ServerResponse.badRequest().build();

        return ServerResponse.ok().body(gateway.findAllByTenantId(tenantId), Activity.class);
    }
}
