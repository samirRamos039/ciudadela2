package infraestructura.entryPoint.db.materiales;

import domain.entities.models.materiales.Materiales;
import domain.usecase.MaterialesUseCase;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


@Service
public class MaterialesHanddler {

     private final materialesUseCase materialesUseCase;

    public MaterialesRoutes(materialesUseCase materialesUseCase) {
        this.materialesUseCase = materialesUseCase;
    }

    public Mono<ServerResponse> saveMaterial(ServerRequest serverRequest) {
        return reqiest.bodyToMono(Materiales.class)
                .flatMap(materialesUseCase::createMaterial)
                .flatMap(material -> ServerResponse.ok().bodyValue(material))
                .switchIfEmpty(ServerResponse.badRequest().build())
                .onErrorResume(e -> ServerResponse.badRequest().bodyValue(e.getMessage()));
    
}
    
}
