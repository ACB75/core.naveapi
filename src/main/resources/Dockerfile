# Usa una imagen de OpenJDK 17
FROM openjdk:17-jdk-slim
# Crea un directorio para la aplicación
WORKDIR /app
# Copia el archivo jar generado en el contenedor
COPY target/nave-api.jar nave-api.jar
# Define el comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "nave-api.jar"]

FROM openjdk:17-jdk-slim
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
