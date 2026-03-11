package domain.entities.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Materiales {
    private String id;
    private String nombre;
    private int cemento;
    private int grava;
    private int arena;
    private int madera;
    private int adobe;
    private Double precio;
    private Integer stock;
}
