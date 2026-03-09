package web.adapters;

import domain.entities.models.Contact;
import domain.entities.models.gateways.ContactGateway;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import web.mappers.ContactMapper;
import web.repositories.ContactMongoRepository;

@Service
public class ContactRepositoryAdapter implements ContactGateway {

    private final ContactMongoRepository repository;
    private final ContactMapper mapper;

    public ContactRepositoryAdapter(ContactMongoRepository repository, ContactMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Mono<Contact> save(Contact contact) {
        return repository.save(mapper.toCollection(contact))
                .map(mapper::toDomain);
    }

    @Override
    public Mono<Contact> findById(String id, String tenantId) {
        return repository.findByIdAndTenantId(id, tenantId)
                .map(mapper::toDomain);
    }

    @Override
    public Flux<Contact> findAllByTenantId(String tenantId) {
        return repository.findAllByTenantId(tenantId)
                .map(mapper::toDomain);
    }

    @Override
    public Mono<Void> deleteById(String id, String tenantId) {
        return repository.deleteByIdAndTenantId(id, tenantId);
    }
}
