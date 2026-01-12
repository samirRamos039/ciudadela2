package materiales;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import materiales.MaterialesHanddler;

@Configuration
public class MaterialesRoutes {

    @Bean
    public RouterFunction<ServerResponse> materialesRouterFunction(MaterialesHanddler handler) {
        return route(POST("/materiales/crear"), handler::saveMaterial)
                .andRoute(GET("/materiales"), handler::obtenerTodosLosMateriales);
        // .andRoute(GET("/materiales/{id}"), handler::obtenerMaterialPorId)
        // .andRoute(PUT("/materiales/actualizar/{id}"), handler::actualizarMaterial)
        // .andRoute(DELETE("/materiales/eliminar/{id}"), handler::eliminarMaterial);

    }

}
