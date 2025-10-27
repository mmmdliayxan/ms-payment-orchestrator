FROM eclipse-temurin:19-jdk

WORKDIR /app

COPY build/libs/ms-payment-orchestrator-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]