package web.mappers;

import domain.entities.models.Materiales;
import web.collections.MaterialCollections;

public class MaterialMapper {

    public static Materiales toMateriales(MaterialCollections collection) {
        if (collection == null) {
            return null;
        }
        return Materiales.builder()
                .id(collection.getId())
                .nombre(collection.getNombre())
                .cemento(collection.getCemento())
                .grava(collection.getGrava())
                .arena(collection.getArena())
                .madera(collection.getMadera())
                .adobe(collection.getAdobe())
                .precio(collection.getPrecio())
                .stock(collection.getStock())
                .build();
    }

    public static MaterialCollections toMaterialCollections(Materiales domain) {
        if (domain == null) {
            return null;
        }
        MaterialCollections collection = new MaterialCollections();
        collection.setId(domain.getId());
        collection.setNombre(domain.getNombre());
        collection.setCemento(domain.getCemento());
        collection.setGrava(domain.getGrava());
        collection.setArena(domain.getArena());
        collection.setMadera(domain.getMadera());
        collection.setAdobe(domain.getAdobe());
        collection.setPrecio(domain.getPrecio());
        collection.setStock(domain.getStock());
        return collection;
    }
}
