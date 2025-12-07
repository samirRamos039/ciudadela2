package web.materiales;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import web.materiales.documents.MaterialCollections;

public interface MaterialMongoRepository extends ReactivMongoRepository<MaterialCollections, Integer> {
    
}
