package web.mappers;

import domain.entities.models.Activity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import web.collections.ActivityCollection;

@Component
@RequiredArgsConstructor
public class ActivityMapper {

    private final ModelMapper modelMapper;

    public Activity toDomain(ActivityCollection collection) {
        if (collection == null) return null;
        return modelMapper.map(collection, Activity.class);
    }

    public ActivityCollection toCollection(Activity domain) {
        if (domain == null) return null;
        return modelMapper.map(domain, ActivityCollection.class);
    }
}
