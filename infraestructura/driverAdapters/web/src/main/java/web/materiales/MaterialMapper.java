package web.materiales;

import org.modelmapper.ModelMapper;
import web.materiales.collections.MaterialCollection;
import web.materiales.entities.Materiales;


public class MaterialMapper {
    
    private static final ModelMapper modelMapper = new ModelMapper();

    public static MaterialModel toModel(MaterialCollection materialCollection) {
        return modelMapper.map(materialCollection, MaterialModel.class);
    }

    public static MaterialCollection toCollection(Materiales materiales) {
        return modelMapper.map(materiales, MaterialCollection.class);
    }
}
