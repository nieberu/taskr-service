FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD

# Make port 8080 available to the world outside this container
EXPOSE 8080

COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/
RUN mvn package

FROM openjdk:8-jdk-alpine

WORKDIR /app

COPY --from=MAVEN_BUILD /build/target/taskr-service-0.0.1-SNAPSHOT.jar /app/

ENTRYPOINT ["java", "-jar", "taskr-service-0.0.1-SNAPSHOT.jar"]