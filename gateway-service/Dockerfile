FROM openjdk:17-oracle
WORKDIR /app
COPY target/*.jar /app/gateway-service.jar
ENTRYPOINT ["java","-jar","gateway-service.jar"]