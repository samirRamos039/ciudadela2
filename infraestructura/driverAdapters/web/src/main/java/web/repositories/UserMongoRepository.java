package web.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import web.collections.UserCollection;

@Repository
public interface UserMongoRepository extends ReactiveMongoRepository<UserCollection, String> {
    Mono<UserCollection> findByIdAndTenantId(String id, String tenantId);

    Flux<UserCollection> findAllByTenantId(String tenantId);

    Mono<Void> deleteByIdAndTenantId(String id, String tenantId);
}
