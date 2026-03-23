package web.mappers;

import domain.entities.models.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import web.collections.UserCollection;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final ModelMapper modelMapper;

    public User toDomain(UserCollection collection) {
        if (collection == null) return null;
        return modelMapper.map(collection, User.class);
    }

    public UserCollection toCollection(User domain) {
        if (domain == null) return null;
        return modelMapper.map(domain, UserCollection.class);
    }
}
