FROM openjdk:17-oracle
WORKDIR /app
COPY target/*jar /app/discovery-service.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","discovery-service.jar"]