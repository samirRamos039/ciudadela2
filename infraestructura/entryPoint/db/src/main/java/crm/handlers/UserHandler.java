package crm.handlers;

import domain.entities.models.User;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Component
public class UserHandler {

    private final domain.usecases.UserUseCase useCase;

    public UserHandler(domain.usecases.UserUseCase useCase) {
        this.useCase = useCase;
    }

    public Mono<ServerResponse> create(ServerRequest request) {
        return request.bodyToMono(User.class)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request body is required")))
                .flatMap(useCase::save)
                .flatMap(user -> ServerResponse.created(URI.create("/api/users/" + user.getId()))
                        .bodyValue(user));
    }

    public Mono<ServerResponse> register(ServerRequest request) {
        return request.bodyToMono(User.class)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request body is required")))
                .flatMap(useCase::register)
                .flatMap(user -> ServerResponse.created(URI.create("/api/users/" + user.getId()))
                        .bodyValue(user))
                .onErrorResume(e -> ServerResponse.badRequest().bodyValue(e.getMessage()));
    }

    public Mono<ServerResponse> login(ServerRequest request) {
        return request.bodyToMono(domain.entities.models.LoginRequest.class)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "Credentials are required")))
                .flatMap(login -> useCase.login(login.getEmail(), login.getPassword()))
                .flatMap(tokenResponse -> ServerResponse.ok().bodyValue(tokenResponse))
                .onErrorResume(e -> ServerResponse.status(HttpStatus.UNAUTHORIZED).bodyValue(e.getMessage()));
    }

    public Mono<ServerResponse> getById(ServerRequest request) {
        String id = request.pathVariable("id");
        String tenantId = request.headers().firstHeader("X-Tenant-Id");

        if (tenantId == null)
            return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "X-Tenant-Id header is required"));

        return useCase.findById(id, tenantId)
                .flatMap(user -> ServerResponse.ok().bodyValue(user))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> getAll(ServerRequest request) {
        String tenantId = request.headers().firstHeader("X-Tenant-Id");

        if (tenantId == null)
            return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "X-Tenant-Id header is required"));

        return ServerResponse.ok().body(useCase.findAllByTenantId(tenantId), User.class);
    }

    public Mono<ServerResponse> getAllUsers(ServerRequest request) {
        return ServerResponse.ok().body(useCase.findAll(), User.class);
    }
}
