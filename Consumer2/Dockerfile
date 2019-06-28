FROM openjdk:8-jdk-alpine

RUN apk update && apk add bash

VOLUME /tmp

COPY target/*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]