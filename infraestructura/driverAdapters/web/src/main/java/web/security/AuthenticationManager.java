package web.security;

import domain.ports.TokenGateway;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@Component
public class AuthenticationManager implements ReactiveAuthenticationManager {

    private final TokenGateway tokenGateway;

    public AuthenticationManager(TokenGateway tokenGateway) {
        this.tokenGateway = tokenGateway;
    }

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        String authToken = authentication.getCredentials().toString();

        String username;
        try {
            username = tokenGateway.extractUsername(authToken);
        } catch (Exception e) {
            username = null;
        }

        if (username != null && tokenGateway.isTokenValid(authToken, username)) {
            // we skip roles here for simplicity, or we can extract roles from JWT
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                    username,
                    authToken,
                    new ArrayList<>()
            );
            return Mono.just(auth);
        } else {
            return Mono.empty();
        }
    }
}
