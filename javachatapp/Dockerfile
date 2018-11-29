FROM openjdk:8-jdk-alpine
COPY ./chatapp-0.0.1-SNAPSHOT-all.jar /chatapp
WORKDIR /chatapp
EXPOSE 8080
CMD ["java", "-jar", "chatapp-0.0.1-SNAPSHOT-all.jar"]