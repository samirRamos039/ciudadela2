package web.materiales;

import org.modelmapper.ModelMapper;
import web.collections.MaterialCollections;
import domain.entities.models.Materiales;


public class MaterialMapper {
    
    private static final ModelMapper modelMapper = new ModelMapper();

    public static Materiales toMateriales(MaterialCollections materialCollection) {
        return modelMapper.map(materialCollection, Materiales.class);
    }

    public static MaterialCollections toMaterialCollections(Materiales materiales) {
        return modelMapper.map(materiales, MaterialCollections.class);
    }
}
