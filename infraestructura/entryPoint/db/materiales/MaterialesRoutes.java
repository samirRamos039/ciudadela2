package infraestructura.entryPoint.db.materiales;

import org.springframework.context.annotation.Configuration;

@Configuration
public class MaterialesRoutes {

    @Bean
    public RouterFunction<ServerResponse> materialesRouterFunction(MaterialesHandler handler) {
        return route(POST("/materiales/crear"), handler::crearMaterial)
                .andRoute(GET("/materiales/{id}"), handler::obtenerMaterialPorId)
                .andRoute(GET("/materiales"), handler::obtenerTodosLosMateriales)
                .andRoute(PUT("/materiales/actualizar/{id}"), handler::actualizarMaterial)
                .andRoute(DELETE("/materiales/eliminar/{id}"), handler::eliminarMaterial);
                
    }

   

}

