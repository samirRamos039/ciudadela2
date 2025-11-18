package domain.entities.models.gateways;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.LocalDate;
import domain.entities.models.SolicitudConstruccion;
import domain.entities.models.TipoConstruccion;

public interface SolicitudConstruccionGateways {
    
    // Operaciones CRUD básicas
    Mono<SolicitudConstruccion> guardar(SolicitudConstruccion solicitud);
    Mono<SolicitudConstruccion> buscarPorId(String id);
    Flux<SolicitudConstruccion> buscarTodas();
    Mono<SolicitudConstruccion> actualizar(String id, SolicitudConstruccion solicitud);
    Mono<Boolean> eliminar(String id);
    
    // Búsquedas por criterios específicos
    Flux<SolicitudConstruccion> buscarPorTipo(TipoConstruccion tipo);
    Flux<SolicitudConstruccion> buscarPorFechaSolicitud(LocalDate fecha);
    Flux<SolicitudConstruccion> buscarPorRangoFechas(LocalDate desde, LocalDate hasta);
    
    // Búsquedas por ubicación
    Flux<SolicitudConstruccion> buscarPorCoordenadas(int x, int y);
    Flux<SolicitudConstruccion> buscarEnArea(int xMin, int xMax, int yMin, int yMax);
    Mono<Boolean> existeSolicitudEnUbicacion(int x, int y);
    
    // Operaciones de análisis y reportes
    Mono<Long> contarPorTipo(TipoConstruccion tipo);
    Mono<Map<TipoConstruccion, Long>> contarSolicitudesPorTipo();
    Flux<SolicitudConstruccion> buscarSolicitudesRecientes(int dias);
    
    // Validaciones de negocio
    Mono<Boolean> validarUbicacionDisponible(int x, int y);
    Mono<Boolean> puedeProcesarse(String solicitudId);
}