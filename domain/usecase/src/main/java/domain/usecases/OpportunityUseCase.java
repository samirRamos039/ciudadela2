package domain.usecases;

import domain.entities.models.Opportunity;
import domain.ports.OpportunityGateway;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OpportunityUseCase {

    private final OpportunityGateway opportunityGateway;

    public OpportunityUseCase(OpportunityGateway opportunityGateway) {
        this.opportunityGateway = opportunityGateway;
    }

    public Mono<Opportunity> save(Opportunity opportunity) {
        return opportunityGateway.save(opportunity);
    }

    public Mono<Opportunity> findById(String id, String tenantId) {
        return opportunityGateway.findById(id, tenantId);
    }

    public Flux<Opportunity> findAllByTenantId(String tenantId) {
        return opportunityGateway.findAllByTenantId(tenantId);
    }

    public Mono<Void> deleteById(String id, String tenantId) {
        return opportunityGateway.deleteById(id, tenantId);
    }
}
