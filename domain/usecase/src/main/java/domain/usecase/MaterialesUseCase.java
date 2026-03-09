package domain.usecase;

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
        return materialesGateway.guardar(material);
    }

    public Flux<Materiales> getAllMaterials() {
        return materialesGateway.buscarTodos();
    }

    public Mono<Materiales> getMaterialById(String id) {
        return materialesGateway.buscarPorId(id);
    }

    public Mono<Void> updateMaterial(String id, Materiales material) {
        return materialesGateway.actualizar(id, material);
    }

    public Mono<Boolean> deleteMaterial(String id) {
        return materialesGateway.eliminar(id);
    }
    
    
}
