FROM openjdk
WORKDIR /app
COPY target/spring-rest-api-0.0.1-SNAPSHOT.jar .
CMD ["java","-jar","spring-rest-api-0.0.1-SNAPSHOT.jar"]