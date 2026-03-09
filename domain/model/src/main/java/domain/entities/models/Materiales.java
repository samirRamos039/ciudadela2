package domain.entities.models;

import lombok.AllArgsConstructor;
<<<<<<< HEAD
import lombok.Builder;
=======
>>>>>>> 2a6218b4e48bf110b4a220b2843814a211e9fd4c
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
<<<<<<< HEAD
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Materiales {
    private String id;
    private int cemento;
    private String nombre;
}
=======
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
>>>>>>> 2a6218b4e48bf110b4a220b2843814a211e9fd4c
