package web.mappers;

import domain.entities.models.User;
import org.springframework.stereotype.Component;
import web.collections.UserCollection;

@Component
public class UserMapper {

    public User toDomain(UserCollection collection) {
        if (collection == null)
            return null;
        return User.builder()
                .id(collection.getId())
                .tenantId(collection.getTenantId())
                .email(collection.getEmail())
                .passwordHash(collection.getPasswordHash())
                .fullName(collection.getFullName())
                .role(collection.getRole())
                .status(collection.getStatus())
                .createdAt(collection.getCreatedAt())
                .build();
    }

    public UserCollection toCollection(User domain) {
        if (domain == null)
            return null;
        return UserCollection.builder()
                .id(domain.getId())
                .tenantId(domain.getTenantId())
                .email(domain.getEmail())
                .passwordHash(domain.getPasswordHash())
                .fullName(domain.getFullName())
                .role(domain.getRole())
                .status(domain.getStatus())
                .createdAt(domain.getCreatedAt())
                .build();
    }
}
