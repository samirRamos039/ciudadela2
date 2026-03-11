package crm.handlers;

import domain.entities.models.Contact;
import domain.ports.ContactGateway;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
public class ContactHandler {

    private final ContactGateway gateway;

    public ContactHandler(ContactGateway gateway) {
        this.gateway = gateway;
    }

    public Mono<ServerResponse> create(ServerRequest request) {
        String tenantId = request.headers().firstHeader("X-Tenant-Id");

        return request.bodyToMono(Contact.class)
                .map(contact -> {
                    if (tenantId != null)
                        contact.setTenantId(tenantId);
                    return contact;
                })
                .flatMap(gateway::save)
                .flatMap(contact -> ServerResponse.created(URI.create("/api/contacts/" + contact.getId()))
                        .bodyValue(contact));
    }

    public Mono<ServerResponse> getById(ServerRequest request) {
        String id = request.pathVariable("id");
        String tenantId = request.headers().firstHeader("X-Tenant-Id");

        if (tenantId == null)
            return ServerResponse.badRequest().build();

        return gateway.findById(id, tenantId)
                .flatMap(contact -> ServerResponse.ok().bodyValue(contact))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> getAll(ServerRequest request) {
        String tenantId = request.headers().firstHeader("X-Tenant-Id");

        if (tenantId == null)
            return ServerResponse.badRequest().build();

        return ServerResponse.ok().body(gateway.findAllByTenantId(tenantId), Contact.class);
    }
}
