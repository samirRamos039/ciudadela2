package web.adapters;

import domain.entities.models.Opportunity;
import domain.entities.models.gateways.OpportunityGateway;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import web.mappers.OpportunityMapper;
import web.repositories.OpportunityMongoRepository;

@Service
public class OpportunityRepositoryAdapter implements OpportunityGateway {

    private final OpportunityMongoRepository repository;
    private final OpportunityMapper mapper;

    public OpportunityRepositoryAdapter(OpportunityMongoRepository repository, OpportunityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Mono<Opportunity> save(Opportunity opportunity) {
        return repository.save(mapper.toCollection(opportunity))
                .map(mapper::toDomain);
    }

    @Override
    public Mono<Opportunity> findById(String id, String tenantId) {
        return repository.findByIdAndTenantId(id, tenantId)
                .map(mapper::toDomain);
    }

    @Override
    public Flux<Opportunity> findAllByTenantId(String tenantId) {
        return repository.findAllByTenantId(tenantId)
                .map(mapper::toDomain);
    }

    @Override
    public Mono<Void> deleteById(String id, String tenantId) {
        return repository.deleteByIdAndTenantId(id, tenantId);
    }
}
