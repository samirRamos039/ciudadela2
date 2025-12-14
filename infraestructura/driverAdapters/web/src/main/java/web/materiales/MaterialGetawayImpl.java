package web.materiales;


import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import domain.entities.models.Materiales;
import web.materiales.MaterialMongoRepository;
import domain.ports.MaterialesGateway;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class MaterialGetawayImpl implements MaterialesGateway {

    @Autowired
    private MaterialMongoRepository materialMongoRepository;

    @Override
    public Flux<Materiales> buscarTodos() {
        return materialMongoRepository.findAll()
                                      .map(MaterialMapper::toMateriales);
    }

    @Override
    public Mono<Materiales> guardar(Materiales materiales) {
        return materialMongoRepository.save(MaterialMapper.toMaterialCollections(materiales))
                                      .map(MaterialMapper::toMateriales);
    }

    
    
}
