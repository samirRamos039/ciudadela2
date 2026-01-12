package domain.entities.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Materiales {
        String id;
        int cemento;
        int grava;
        int arena;
        int madera;
        int adobe;

}