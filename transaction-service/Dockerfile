FROM openjdk:17-oracle
WORKDIR /app
COPY target/*.jar /app/transaction-service.jar
ENTRYPOINT ["java","-jar","transaction-service.jar"]