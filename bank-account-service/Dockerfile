FROM openjdk:8-jdk-alpine
COPY target/user-account-0.0.1-SNAPSHOT.jar user-account-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/user-account-0.0.1-SNAPSHOT.jar","-Dspring.profiles.active=docker"]