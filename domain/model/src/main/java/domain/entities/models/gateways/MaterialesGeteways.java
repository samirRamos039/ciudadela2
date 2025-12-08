package domain.entities.models.gateways;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import domain.entities.models.Materiales;

public interface MaterialesGeteways {
    
    // Operaciones CRUD reactivas
    Mono<Materiales> guardar(Materiales materiales);
   // Mono<Materiales> buscarPorId(String id);
    Flux<Materiales> buscarTodos();
   // Mono<Void> actualizar(String id, Materiales materiales);
    //Mono<Boolean> eliminar(String id);
    
    /*  Operaciones específicas del dominio
    Mono<Boolean> verificarDisponibilidad(Materiales materialesRequeridos);
    Mono<Materiales> consumirMateriales(Materiales materialesAConsumir);
    Mono<Materiales> agregarMateriales(Materiales materialesAAgregar);
    
    // Consultas específicas
    Mono<Integer> obtenerStockTotal();
    Flux<Materiales> buscarPorRangoDeCemento(int min, int max);*/
}