package domain.usecases;

import domain.entities.models.Activity;
import domain.ports.ActivityGateway;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ActivityUseCase {

    private final ActivityGateway activityGateway;

    public ActivityUseCase(ActivityGateway activityGateway) {
        this.activityGateway = activityGateway;
    }

    public Mono<Activity> save(Activity activity) {
        return activityGateway.save(activity);
    }

    public Mono<Activity> findById(String id, String tenantId) {
        return activityGateway.findById(id, tenantId);
    }

    public Flux<Activity> findAllByTenantId(String tenantId) {
        return activityGateway.findAllByTenantId(tenantId);
    }

    public Mono<Void> deleteById(String id, String tenantId) {
        return activityGateway.deleteById(id, tenantId);
    }
}
