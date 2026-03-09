package web.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import web.collections.ActivityCollection;

@Repository
public interface ActivityMongoRepository extends ReactiveMongoRepository<ActivityCollection, String> {
    Mono<ActivityCollection> findByIdAndTenantId(String id, String tenantId);

    Flux<ActivityCollection> findAllByTenantId(String tenantId);

    Mono<Void> deleteByIdAndTenantId(String id, String tenantId);
}
