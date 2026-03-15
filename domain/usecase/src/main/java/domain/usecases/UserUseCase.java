package domain.usecases;

import domain.entities.models.User;
import domain.ports.UserGateway;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserUseCase {

    private final UserGateway userGateway;

    public UserUseCase(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public Mono<User> save(User user) {
        return userGateway.save(user);
    }

    public Mono<User> findById(String id, String tenantId) {
        return userGateway.findById(id, tenantId);
    }

    public Flux<User> findAllByTenantId(String tenantId) {
        return userGateway.findAllByTenantId(tenantId);
    }

    public Mono<Void> deleteById(String id, String tenantId) {
        return userGateway.deleteById(id, tenantId);
    }
}
