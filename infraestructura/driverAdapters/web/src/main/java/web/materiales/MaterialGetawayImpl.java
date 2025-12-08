package web.materiales;


import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import web.materiales.entities.Materiales;
import web.materiales.repositories.MaterialMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class MaterialGetawayImpl implements MaterialGetaway {

    @Autowired
    private MaterialMongoRepository materialMongoRepository;

    @Override
    public Flux<Materiales> buscarTodos() {
        return materialMongoRepository.findAll()
                                      .map(MaterialMapper::toMateriales);
    }

    @Override
    public Mono<Materiales> guardar(Materiales materiales) {
        return materialMongoRepository.save(MaterialMapper.toMaterial(materiales))
                                      .map(MaterialMapper::toMateriales);
    }

    
    
}
