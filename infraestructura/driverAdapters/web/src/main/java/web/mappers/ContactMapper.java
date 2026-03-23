package web.mappers;

import domain.entities.models.Contact;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import web.collections.ContactCollection;

@Component
@RequiredArgsConstructor
public class ContactMapper {

    private final ModelMapper modelMapper;

    public Contact toDomain(ContactCollection collection) {
        if (collection == null) return null;
        return modelMapper.map(collection, Contact.class);
    }

    public ContactCollection toCollection(Contact domain) {
        if (domain == null) return null;
        return modelMapper.map(domain, ContactCollection.class);
    }
}
