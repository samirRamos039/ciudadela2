package domain.usecases;

import domain.entities.models.Contact;
import domain.ports.ContactGateway;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ContactUseCase {

    private final ContactGateway contactGateway;

    public ContactUseCase(ContactGateway contactGateway) {
        this.contactGateway = contactGateway;
    }

    public Mono<Contact> save(Contact contact) {
        return contactGateway.save(contact);
    }

    public Mono<Contact> findById(String id, String tenantId) {
        return contactGateway.findById(id, tenantId);
    }

    public Flux<Contact> findAllByTenantId(String tenantId) {
        return contactGateway.findAllByTenantId(tenantId);
    }

    public Mono<Void> deleteById(String id, String tenantId) {
        return contactGateway.deleteById(id, tenantId);
    }
}
