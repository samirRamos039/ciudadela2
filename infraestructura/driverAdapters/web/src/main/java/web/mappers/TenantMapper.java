package web.mappers;

import domain.entities.models.Tenant;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import web.collections.TenantCollection;

@Component
@RequiredArgsConstructor
public class TenantMapper {

    private final ModelMapper modelMapper;

    public Tenant toDomain(TenantCollection collection) {
        if (collection == null) return null;
        return modelMapper.map(collection, Tenant.class);
    }

    public TenantCollection toCollection(Tenant domain) {
        if (domain == null) return null;
        return modelMapper.map(domain, TenantCollection.class);
    }
}
