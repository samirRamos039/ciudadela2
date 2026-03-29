# Stage 1: Construcción de la aplicación
FROM gradle:8-jdk17 AS build
WORKDIR /workspace

# Copiamos todo el código fuente al contenedor
COPY . .

# Ejecutamos la tarea de bootJar específica del módulo app-main
RUN gradle clean :app-main:bootJar --no-daemon

# Stage 2: Imagen para ejecución (más ligera)
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copiamos el JAR generado en la fase anterior (usando la ruta del módulo appMain)
COPY --from=build /workspace/appMain/aplication/build/libs/*.jar app.jar

# Exponemos el puerto donde corre Spring Boot
EXPOSE 8080

# Comando para iniciar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
