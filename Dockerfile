FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080:8080
COPY target/*jar app.jar
ENTRYPOINT ["java", "-jar","/app.jar", "-spring.config.location=file:./src/main/resources/application.yml"]