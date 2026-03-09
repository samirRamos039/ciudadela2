package web.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import web.collections.TenantCollection;

@Repository
public interface TenantMongoRepository extends ReactiveMongoRepository<TenantCollection, String> {
}
