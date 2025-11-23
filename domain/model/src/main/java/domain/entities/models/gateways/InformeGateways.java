package domain.entities.models.gateways;

import domain.entities.models.InformeConstruccion;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface InformeGateways {
    Mono<InformeConstruccion> saveInforme(InformeConstruccion informe);

    Flux<InformeConstruccion> getInforme();

    Mono<InformeConstruccion> getInformeById(int id);

    Mono<Void> deletInforme(int id);

    Mono<InformeConstruccion> updateInforme(int id);

}
