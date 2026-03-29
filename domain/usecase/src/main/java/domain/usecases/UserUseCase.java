package domain.usecases;

import domain.entities.models.User;
import domain.ports.UserGateway;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserUseCase {

    private final UserGateway userGateway;
    private final domain.ports.PasswordEncoderGateway passwordEncoder;
    private final domain.ports.TokenGateway tokenGateway;

    public UserUseCase(UserGateway userGateway, domain.ports.PasswordEncoderGateway passwordEncoder, domain.ports.TokenGateway tokenGateway) {
        this.userGateway = userGateway;
        this.passwordEncoder = passwordEncoder;
        this.tokenGateway = tokenGateway;
    }

    public Mono<User> save(User user) {
        if (user.getPasswordHash() != null) {
            user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        }
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

    public Flux<User> findAll() {
        return userGateway.findAll();
    }

    public Mono<User> register(User user) {
        return userGateway.findByEmail(user.getEmail())
                .flatMap(existingUser -> Mono.<User>error(new IllegalArgumentException("El usuario con este correo electrónico ya está registrado.")))
                .switchIfEmpty(Mono.defer(() -> {
                    user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
                    return userGateway.save(user);
                }));
    }

    public Mono<domain.entities.models.TokenResponse> login(String email, String password) {
        return userGateway.findByEmail(email)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Usuario no encontrado.")))
                .flatMap(user -> {
                    if (passwordEncoder.matches(password, user.getPasswordHash())) {
                        String token = tokenGateway.generateToken(user);
                        return Mono.just(new domain.entities.models.TokenResponse(token, user));
                    } else {
                        return Mono.error(new IllegalArgumentException("La clave no coincide."));
                    }
                });
    }

    public Mono<Boolean> isRegistered(String email) {
        return userGateway.findByEmail(email)
                .map(user -> true)
                .defaultIfEmpty(false);
    }

}
