package domain.ports;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import domain.entities.models.Materiales;
import domain.entities.models.TipoConstruccion;

public interface CatalogoTipoConstruccion {

    // Operaciones CRUD básicas
    Mono<TipoConstruccion> guardar(TipoConstruccion tipo);

    Mono<TipoConstruccion> buscarPorNombre(String nombre);

    Flux<TipoConstruccion> buscarTodos();

    Mono<TipoConstruccion> actualizar(String nombre, TipoConstruccion tipo);

    Mono<Boolean> eliminar(String nombre);

    // Búsquedas y consultas específicas
    Flux<TipoConstruccion> buscarPorRangoDiasConstruccion(int minDias, int maxDias);

    Mono<Boolean> existeTipo(String nombre);

    // Operaciones relacionadas con materiales
    Flux<TipoConstruccion> buscarPorMaterialRequerido(String material, int cantidadMinima);

    Mono<Materiales> calcularMaterialesParaMultiple(String nombreTipo, int cantidad);

    Flux<TipoConstruccion> buscarPorPresupuestoAproximado(Mono<Double> presupuestoMaximo);

    // Operaciones de validación y análisis
    Mono<Boolean> validarTipoConstruccion(TipoConstruccion tipo);

    Mono<Double> calcularCostoEstimado(String nombreTipo, Mono<Double> precioCemento,
            Mono<Double> precioGrava, Mono<Double> precioArena,
            Mono<Double> precioMadera, Mono<Double> precioAdobe);

    // Operaciones de catálogo predefinido
    Flux<TipoConstruccion> obtenerTiposPopulares();

    Flux<TipoConstruccion> buscarPorComplejidad(String complejidad); // "simple", "media", "compleja"
}
