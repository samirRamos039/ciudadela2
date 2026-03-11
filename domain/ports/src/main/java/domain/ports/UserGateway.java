package domain.ports;

import domain.entities.models.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserGateway {
    Mono<User> save(User user);

    Mono<User> findById(String id, String tenantId);

    Flux<User> findAllByTenantId(String tenantId);

    Mono<Void> deleteById(String id, String tenantId);
}
