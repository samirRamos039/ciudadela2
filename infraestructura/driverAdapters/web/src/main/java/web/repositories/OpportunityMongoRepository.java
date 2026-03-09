package web.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import web.collections.OpportunityCollection;

@Repository
public interface OpportunityMongoRepository extends ReactiveMongoRepository<OpportunityCollection, String> {
    Mono<OpportunityCollection> findByIdAndTenantId(String id, String tenantId);

    Flux<OpportunityCollection> findAllByTenantId(String tenantId);

    Mono<Void> deleteByIdAndTenantId(String id, String tenantId);
}
