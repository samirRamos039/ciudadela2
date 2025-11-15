public record InformeConstruccion(
    List<OrdenConstruccion> pendientes,                            
    Map<String, Long> terminadasPorTipo,
    List<OrdenConstruccion> enProgreso,                             
    LocalDate fechaFinProyecto
    ) {}
