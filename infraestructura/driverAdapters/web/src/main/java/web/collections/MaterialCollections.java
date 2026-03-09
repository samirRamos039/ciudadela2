package web.collections;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
@Document(collection = "material")
public class MaterialCollections {

    @Id
    private String id;
    private int cemento;
    private int grava;
    private int arena;
    private int madera;
    private int adobe;

}
