package web.mappers;

import domain.entities.models.Activity;
import org.springframework.stereotype.Component;
import web.collections.ActivityCollection;

@Component
public class ActivityMapper {

    public Activity toDomain(ActivityCollection collection) {
        if (collection == null)
            return null;
        return Activity.builder()
                .id(collection.getId())
                .tenantId(collection.getTenantId())
                .userId(collection.getUserId())
                .type(collection.getType())
                .relatedToType(collection.getRelatedToType())
                .relatedToId(collection.getRelatedToId())
                .description(collection.getDescription())
                .dueDate(collection.getDueDate())
                .isCompleted(collection.getIsCompleted())
                .createdAt(collection.getCreatedAt())
                .build();
    }

    public ActivityCollection toCollection(Activity domain) {
        if (domain == null)
            return null;
        return ActivityCollection.builder()
                .id(domain.getId())
                .tenantId(domain.getTenantId())
                .userId(domain.getUserId())
                .type(domain.getType())
                .relatedToType(domain.getRelatedToType())
                .relatedToId(domain.getRelatedToId())
                .description(domain.getDescription())
                .dueDate(domain.getDueDate())
                .isCompleted(domain.getIsCompleted())
                .createdAt(domain.getCreatedAt())
                .build();
    }
}
