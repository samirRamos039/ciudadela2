package domain.ports;

import domain.entities.models.Tenant;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TenantGateway {
    Mono<Tenant> save(Tenant tenant);

    Mono<Tenant> findById(String id);

    Flux<Tenant> findAll();

    Mono<Void> deleteById(String id);
}
