package web.adapters;

import domain.entities.models.User;
import domain.entities.models.gateways.UserGateway;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import web.mappers.UserMapper;
import web.repositories.UserMongoRepository;

@Service
public class UserRepositoryAdapter implements UserGateway {

    private final UserMongoRepository repository;
    private final UserMapper mapper;

    public UserRepositoryAdapter(UserMongoRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Mono<User> save(User user) {
        return repository.save(mapper.toCollection(user))
                .map(mapper::toDomain);
    }

    @Override
    public Mono<User> findById(String id, String tenantId) {
        return repository.findByIdAndTenantId(id, tenantId)
                .map(mapper::toDomain);
    }

    @Override
    public Flux<User> findAllByTenantId(String tenantId) {
        return repository.findAllByTenantId(tenantId)
                .map(mapper::toDomain);
    }

    @Override
    public Mono<Void> deleteById(String id, String tenantId) {
        return repository.deleteByIdAndTenantId(id, tenantId);
    }
}
