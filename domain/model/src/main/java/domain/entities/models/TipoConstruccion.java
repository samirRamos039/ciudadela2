package domain.entities.models;


public record TipoConstruccion(
    String nombre, 
    Materiales materialesRequeridos, 
    int diasConstruccion
    ) {}
