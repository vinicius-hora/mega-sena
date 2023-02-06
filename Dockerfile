FROM maven:3.8.2-openjdk-17-slim as build

WORKDIR /app

COPY pom.xml .
RUN mvn verify clean --fail-never

COPY src src
RUN mvn package -DskipTests

FROM openjdk:17-slim-buster

WORKDIR /app

COPY --from=build app/target/megasema-0.0.1-SNAPSHOT.jar app.jar

COPY src/main/resources/application.yml application.yml

ENTRYPOINT java -DskipTests -jar app.jar