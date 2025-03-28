# Usa la imagen base de OpenJDK 21 Slim
FROM openjdk:21-slim as build
# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR de la aplicación al contenedor
COPY target/*.jar app.jar

# Expone el puerto en el que corre la aplicación
EXPOSE 8001

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/app.jar"]