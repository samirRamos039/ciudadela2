package web.mappers;

import domain.entities.models.Contact;
import org.springframework.stereotype.Component;
import web.collections.ContactCollection;

@Component
public class ContactMapper {

    public Contact toDomain(ContactCollection collection) {
        if (collection == null)
            return null;
        return Contact.builder()
                .id(collection.getId())
                .tenantId(collection.getTenantId())
                .assignedUserId(collection.getAssignedUserId())
                .firstName(collection.getFirstName())
                .lastName(collection.getLastName())
                .email(collection.getEmail())
                .phone(collection.getPhone())
                .companyName(collection.getCompanyName())
                .status(collection.getStatus())
                .tags(collection.getTags())
                .createdAt(collection.getCreatedAt())
                .updatedAt(collection.getUpdatedAt())
                .build();
    }

    public ContactCollection toCollection(Contact domain) {
        if (domain == null)
            return null;
        return ContactCollection.builder()
                .id(domain.getId())
                .tenantId(domain.getTenantId())
                .assignedUserId(domain.getAssignedUserId())
                .firstName(domain.getFirstName())
                .lastName(domain.getLastName())
                .email(domain.getEmail())
                .phone(domain.getPhone())
                .companyName(domain.getCompanyName())
                .status(domain.getStatus())
                .tags(domain.getTags())
                .createdAt(domain.getCreatedAt())
                .updatedAt(domain.getUpdatedAt())
                .build();
    }
}
