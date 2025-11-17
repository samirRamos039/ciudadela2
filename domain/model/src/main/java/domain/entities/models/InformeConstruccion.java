package domain.entities.models;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public record InformeConstruccion(
    List<OrdenConstruccion> pendientes,                            
    Map<String, Long> terminadasPorTipo,
    List<OrdenConstruccion> enProgreso,                             
    LocalDate fechaFinProyecto
    ) {}
