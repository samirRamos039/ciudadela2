package web.adapters;

import domain.entities.models.Activity;
import domain.ports.ActivityGateway;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import web.mappers.ActivityMapper;
import web.repositories.ActivityMongoRepository;

@Service
public class ActivityRepositoryAdapter implements ActivityGateway {

    private final ActivityMongoRepository repository;
    private final ActivityMapper mapper;

    public ActivityRepositoryAdapter(ActivityMongoRepository repository, ActivityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Mono<Activity> save(Activity activity) {
        return repository.save(mapper.toCollection(activity))
                .map(mapper::toDomain);
    }

    @Override
    public Mono<Activity> findById(String id, String tenantId) {
        return repository.findByIdAndTenantId(id, tenantId)
                .map(mapper::toDomain);
    }

    @Override
    public Flux<Activity> findAllByTenantId(String tenantId) {
        return repository.findAllByTenantId(tenantId)
                .map(mapper::toDomain);
    }

    @Override
    public Mono<Void> deleteById(String id, String tenantId) {
        return repository.deleteByIdAndTenantId(id, tenantId);
    }
}
