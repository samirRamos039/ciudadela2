package domain.ports;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.LocalDate;
import domain.entities.models.OrdenConstruccion;

public interface OrdenConstruccionGateways {

    // Operaciones CRUD básicas
    Mono<OrdenConstruccion> guardar(OrdenConstruccion orden);

    Mono<OrdenConstruccion> buscarPorId(String id);

    Flux<OrdenConstruccion> buscarTodas();

    Mono<OrdenConstruccion> actualizar(String id, OrdenConstruccion orden);

    Mono<Boolean> eliminar(String id);

    // Operaciones específicas de estado
    Mono<OrdenConstruccion> cambiarEstado(String id, String nuevoEstado);

    Flux<OrdenConstruccion> buscarPorEstado(String estado);

    Mono<Boolean> verificarEstado(String id, String estado);

    // Operaciones de fechas
    Flux<OrdenConstruccion> buscarPorRangoFechas(LocalDate fechaInicio, LocalDate fechaFin);

    Flux<OrdenConstruccion> buscarOrdenesPendientes();

    Flux<OrdenConstruccion> buscarOrdenesEnProgreso();

    Flux<OrdenConstruccion> buscarOrdenesCompletadas();

    // Operaciones de análisis
    Mono<Long> contarPorEstado(String estado);

    Mono<Boolean> existeOrdenEnProgreso();

    Flux<OrdenConstruccion> buscarOrdenesAtrasadas(LocalDate fechaReferencia);

    // Operaciones de solicitud
    Flux<OrdenConstruccion> buscarPorTipoSolicitud(String tipoSolicitud);
}