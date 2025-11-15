

public record SolicitudConstruccion(
    String id, 
    TipoConstruccion tipo, 
    int coordenadaX, 
    int coordenadaY, 
    LocalDate fechaSolicitud
    ) {}
