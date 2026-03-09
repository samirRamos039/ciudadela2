package web.mappers;

import domain.entities.models.Tenant;
import org.springframework.stereotype.Component;
import web.collections.TenantCollection;

@Component
public class TenantMapper {

    public Tenant toDomain(TenantCollection collection) {
        if (collection == null)
            return null;
        return Tenant.builder()
                .id(collection.getId())
                .name(collection.getName())
                .subscriptionPlan(collection.getSubscriptionPlan())
                .status(collection.getStatus())
                .domain(collection.getDomain())
                .createdAt(collection.getCreatedAt())
                .updatedAt(collection.getUpdatedAt())
                .build();
    }

    public TenantCollection toCollection(Tenant domain) {
        if (domain == null)
            return null;
        return TenantCollection.builder()
                .id(domain.getId())
                .name(domain.getName())
                .subscriptionPlan(domain.getSubscriptionPlan())
                .status(domain.getStatus())
                .domain(domain.getDomain())
                .createdAt(domain.getCreatedAt())
                .updatedAt(domain.getUpdatedAt())
                .build();
    }
}
