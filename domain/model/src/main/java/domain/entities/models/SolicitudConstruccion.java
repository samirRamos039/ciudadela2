package domain.entities.models;

import java.time.LocalDate;

public record SolicitudConstruccion(
    String id, 
    TipoConstruccion tipo, 
    int coordenadaX, 
    int coordenadaY, 
    LocalDate fechaSolicitud
    ) {}
