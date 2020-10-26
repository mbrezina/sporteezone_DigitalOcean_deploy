# Alpine Linux with OpenJDK JRE
FROM openjdk:15-jdk-alpine3.12

VOLUME /tmp
ARG config=config/application.yaml

# copy JAR into image
COPY target/*.jar /app.jar

# run application with this in the command line:
ENTRYPOINT ["java","-jar","/app.jar"]
#CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=default", "/app.jar"]
