# Etapa de construcción
FROM maven:3.8.6-openjdk-21 AS build

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo pom.xml y descarga las dependencias
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia el código fuente y construye el JAR
COPY src /app/src
RUN mvn package

# Etapa de ejecución
FROM openjdk:21-jdk-slim

# Copia el archivo JAR construido desde la etapa de construcción
COPY --from=build /app/target/prueba-bbdd-almacen-1.0-SNAPSHOT.jar /app/prueba-bbdd-almacen.jar

# Establece el directorio de trabajo
WORKDIR /app

# Expone el puerto en el que la aplicación escucha
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "prueba-bbdd-almacen.jar"]
