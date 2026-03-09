package web.mappers;

import domain.entities.models.Opportunity;
import org.springframework.stereotype.Component;
import web.collections.OpportunityCollection;

@Component
public class OpportunityMapper {

    public Opportunity toDomain(OpportunityCollection collection) {
        if (collection == null)
            return null;
        return Opportunity.builder()
                .id(collection.getId())
                .tenantId(collection.getTenantId())
                .contactId(collection.getContactId())
                .assignedUserId(collection.getAssignedUserId())
                .title(collection.getTitle())
                .value(collection.getValue())
                .currency(collection.getCurrency())
                .pipelineStage(collection.getPipelineStage())
                .expectedCloseDate(collection.getExpectedCloseDate())
                .notes(collection.getNotes())
                .createdAt(collection.getCreatedAt())
                .updatedAt(collection.getUpdatedAt())
                .build();
    }

    public OpportunityCollection toCollection(Opportunity domain) {
        if (domain == null)
            return null;
        return OpportunityCollection.builder()
                .id(domain.getId())
                .tenantId(domain.getTenantId())
                .contactId(domain.getContactId())
                .assignedUserId(domain.getAssignedUserId())
                .title(domain.getTitle())
                .value(domain.getValue())
                .currency(domain.getCurrency())
                .pipelineStage(domain.getPipelineStage())
                .expectedCloseDate(domain.getExpectedCloseDate())
                .notes(domain.getNotes())
                .createdAt(domain.getCreatedAt())
                .updatedAt(domain.getUpdatedAt())
                .build();
    }
}
