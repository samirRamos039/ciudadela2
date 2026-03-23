package web.mappers;

import domain.entities.models.Opportunity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import web.collections.OpportunityCollection;

@Component
@RequiredArgsConstructor
public class OpportunityMapper {

    private final ModelMapper modelMapper;

    public Opportunity toDomain(OpportunityCollection collection) {
        if (collection == null) return null;
        return modelMapper.map(collection, Opportunity.class);
    }

    public OpportunityCollection toCollection(Opportunity domain) {
        if (domain == null) return null;
        return modelMapper.map(domain, OpportunityCollection.class);
    }
}
