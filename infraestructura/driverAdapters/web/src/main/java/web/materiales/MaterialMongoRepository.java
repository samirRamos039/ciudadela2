package web.materiales;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import web.collections.MaterialCollections;

public interface MaterialMongoRepository extends ReactiveMongoRepository<MaterialCollections, String> {

}
