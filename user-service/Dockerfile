FROM openjdk:17-oracle
WORKDIR /app
COPY target/*.jar /app/user-service.jar
ENTRYPOINT ["java","-jar","user-service.jar"]