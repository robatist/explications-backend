FROM openjdk:17
RUN mkdir -p /app
COPY target/backend.main-0.0.1-SNAPSHOT.jar /app/backend-java.jar
WORKDIR /app
EXPOSE 8080
CMD ["java", "-jar", "backend-java.jar"]
