public record OrdenConstruccion(
    String id, 
    SolicitudConstruccion solicitud, 
    String estado,                          
    LocalDate fechaInicio, 
    LocalDate fechaFin
    ) {}
