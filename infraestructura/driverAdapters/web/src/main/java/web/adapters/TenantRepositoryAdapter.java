package web.adapters;

import domain.entities.models.Tenant;
import domain.entities.models.gateways.TenantGateway;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import web.mappers.TenantMapper;
import web.repositories.TenantMongoRepository;

@Service
public class TenantRepositoryAdapter implements TenantGateway {

    private final TenantMongoRepository repository;
    private final TenantMapper mapper;

    public TenantRepositoryAdapter(TenantMongoRepository repository, TenantMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Mono<Tenant> save(Tenant tenant) {
        return repository.save(mapper.toCollection(tenant))
                .map(mapper::toDomain);
    }

    @Override
    public Mono<Tenant> findById(String id) {
        return repository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public Flux<Tenant> findAll() {
        return repository.findAll()
                .map(mapper::toDomain);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return repository.deleteById(id);
    }
}
