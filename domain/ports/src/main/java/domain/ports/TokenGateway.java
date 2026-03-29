package domain.ports;

import domain.entities.models.User;

public interface TokenGateway {
    String generateToken(User user);
    String extractUsername(String token);
    boolean isTokenValid(String token, String username);
}
