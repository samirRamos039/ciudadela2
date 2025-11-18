package domain.entities.models;

import java.time.LocalDate;

public record OrdenConstruccion(
    String id, 
    SolicitudConstruccion solicitud, 
    String estado,                          
    LocalDate fechaInicio, 
    LocalDate fechaFin
    ) {}
