package web.mappers;

import domain.entities.models.Materiales;
import org.modelmapper.ModelMapper;
import web.collections.MaterialCollections;

public class MaterialMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static Materiales toMateriales(MaterialCollections collection) {
        if (collection == null) return null;
        return modelMapper.map(collection, Materiales.class);
    }

    public static MaterialCollections toMaterialCollections(Materiales domain) {
        if (domain == null) return null;
        return modelMapper.map(domain, MaterialCollections.class);
    }
}
