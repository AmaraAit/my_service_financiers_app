FROM openjdk:17-oracle
WORKDIR /app
COPY target/*.jar /app/config-service.jar
ENTRYPOINT ["java","-jar","config-service.jar"]