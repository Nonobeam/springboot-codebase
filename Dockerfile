FROM eclipse-temurin:21
LABEL authors="Nonobeam"

WORKDIR /app

COPY target/*.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]