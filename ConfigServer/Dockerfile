# --------------------------------------------
# Dockerfile za ConfigServer
# --------------------------------------------
FROM eclipse-temurin:17-jre
WORKDIR /app

COPY target/config-server-0.0.1-SNAPSHOT.jar config-server.jar

EXPOSE 8888

ENTRYPOINT ["java","-jar","/app/config-server.jar"]
