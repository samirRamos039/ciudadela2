package domain.usecase;

import domain.entities.models.gateways.MaterialesGeteways;
import domain.entities.models.materiales.Material;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class MaterialesUseCase {

    private final MaterialesGeteways materialesGeteways;

    public MaterialesUseCase(MaterialesGeteways materialesGeteways) {
        this.materialesGeteways = materialesGeteways;
    }

    public Mono<Material> createMaterial(Material material) {
        return materialesGeteways.guardar(material);
    }

    public Flux<Material> getAllMaterials() {
        return materialesGeteways.buscarTodos();
    }
    
    
}
