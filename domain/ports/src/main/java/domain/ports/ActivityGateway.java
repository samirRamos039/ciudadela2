package domain.entities.models.gateways;

import domain.entities.models.Activity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ActivityGateway {
    Mono<Activity> save(Activity activity);

    Mono<Activity> findById(String id, String tenantId);

    Flux<Activity> findAllByTenantId(String tenantId);

    Mono<Void> deleteById(String id, String tenantId);
}
