package domain.ports;

import domain.entities.models.Contact;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ContactGateway {
    Mono<Contact> save(Contact contact);

    Mono<Contact> findById(String id, String tenantId);

    Flux<Contact> findAllByTenantId(String tenantId);

    Mono<Void> deleteById(String id, String tenantId);
}
