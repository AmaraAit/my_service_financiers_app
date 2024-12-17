FROM openjdk:17-oracle
WORKDIR /app
COPY target/*.jar /app/loan-service.jar
ENTRYPOINT ["java","-jar","loan-service.jar"]