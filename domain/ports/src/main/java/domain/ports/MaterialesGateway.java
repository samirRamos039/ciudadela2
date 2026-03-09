package domain.ports;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import domain.entities.models.Materiales;

public interface MaterialesGateway {

    // Operaciones CRUD reactivas
    Mono<Materiales> guardar(Materiales materiales);
<<<<<<< HEAD
    Mono<Materiales> buscarPorId(String id);
    Flux<Materiales> buscarTodos();
    Mono<Void> actualizar(String id, Materiales materiales);
    Mono<Boolean> eliminar(String id);
    
    /*  Operaciones específicas del dominio
    Mono<Boolean> verificarDisponibilidad(Materiales materialesRequeridos);
    Mono<Materiales> consumirMateriales(Materiales materialesAConsumir);
    Mono<Materiales> agregarMateriales(Materiales materialesAAgregar);
    
    // Consultas específicas
    Mono<Integer> obtenerStockTotal();
    Flux<Materiales> buscarPorRangoDeCemento(int min, int max);*/
=======

    Mono<Materiales> buscarPorId(String id);

    Flux<Materiales> buscarTodos();

    Mono<Materiales> actualizar(String id, Materiales materiales);

    Mono<Materiales> eliminar(String id);

    /*
     * Operaciones específicas del dominio
     * Mono<Boolean> verificarDisponibilidad(Materiales materialesRequeridos);
     * Mono<Materiales> consumirMateriales(Materiales materialesAConsumir);
     * Mono<Materiales> agregarMateriales(Materiales materialesAAgregar);
     * 
     * // Consultas específicas
     * Mono<Integer> obtenerStockTotal();
     * Flux<Materiales> buscarPorRangoDeCemento(int min, int max);
     */
>>>>>>> 2a6218b4e48bf110b4a220b2843814a211e9fd4c
}