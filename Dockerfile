FROM eclipse-temurin:17-jdk-jammy

COPY target/hrm.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
