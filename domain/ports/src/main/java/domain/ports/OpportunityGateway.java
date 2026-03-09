package domain.entities.models.gateways;

import domain.entities.models.Opportunity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OpportunityGateway {
    Mono<Opportunity> save(Opportunity opportunity);

    Mono<Opportunity> findById(String id, String tenantId);

    Flux<Opportunity> findAllByTenantId(String tenantId);

    Mono<Void> deleteById(String id, String tenantId);
}
