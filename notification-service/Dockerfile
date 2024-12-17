FROM openjdk:17-oracle
WORKDIR /app
COPY target/*.jar /app/notification-service.jar
ENTRYPOINT ["java","-jar","notification-service.jar"]