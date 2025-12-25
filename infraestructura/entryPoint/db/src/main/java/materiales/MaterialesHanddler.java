package materiales;

import domain.entities.models.Materiales;
import domain.usecases.MaterialesUseCase;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


@Service
public class MaterialesHanddler {

     private final MaterialesUseCase materialesUseCase;

    public MaterialesHanddler(MaterialesUseCase materialesUseCase) {
        this.materialesUseCase = materialesUseCase;
    }

    public Mono<ServerResponse> saveMaterial(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Materiales.class)
                .flatMap(materialesUseCase::createMaterial)
                .flatMap(material -> ServerResponse.ok().bodyValue(material))
                .switchIfEmpty(ServerResponse.badRequest().build())
                .onErrorResume(e -> ServerResponse.badRequest().bodyValue(e.getMessage()));
    
    }

    public Mono<ServerResponse> obtenerTodosLosMateriales(ServerRequest serverRequest) {
        return ServerResponse.ok().body(materialesUseCase.getAllMaterials(), Materiales.class);
    }
    
}
