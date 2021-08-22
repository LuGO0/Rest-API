FROM openjdk:8
ADD target/restapi.jar restapi.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "restapi.jar"]