FROM openjdk:17-oracle
WORKDIR /app
COPY target/*.jar /app/account-service.jar
ENTRYPOINT ["java","-jar","account-service.jar"]