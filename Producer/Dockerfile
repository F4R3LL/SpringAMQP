FROM openjdk:8-jdk-alpine

RUN apk update && apk add bash

VOLUME /tmp

ADD target/*.jar producer.jar

ENV JAVA_OPTS=""

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /producer.jar"]
