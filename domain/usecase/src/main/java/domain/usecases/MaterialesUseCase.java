package domain.usecases;

import domain.ports.MaterialesGateway;
import domain.entities.models.Materiales;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MaterialesUseCase {

    private final MaterialesGateway materialesGateway;

    public MaterialesUseCase(MaterialesGateway materialesGateway) {
        this.materialesGateway = materialesGateway;
    }

    public Mono<Materiales> createMaterial(Materiales material) {
        if (material.getAdobe() > 0)
            return Mono.error(new Exception("Si hay materiales"));
        return materialesGateway.guardar(material);
    }

    public Flux<Materiales> getAllMaterials() {
        return materialesGateway.buscarTodos();
    }

}
