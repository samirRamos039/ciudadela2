package web.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import web.collections.ContactCollection;

@Repository
public interface ContactMongoRepository extends ReactiveMongoRepository<ContactCollection, String> {
    Mono<ContactCollection> findByIdAndTenantId(String id, String tenantId);

    Flux<ContactCollection> findAllByTenantId(String tenantId);

    Mono<Void> deleteByIdAndTenantId(String id, String tenantId);
}
