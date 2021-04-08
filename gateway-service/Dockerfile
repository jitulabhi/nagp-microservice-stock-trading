FROM openjdk:8-jdk-alpine
COPY target/gateway-0.0.1-SNAPSHOT.jar gateway-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/gateway-0.0.1-SNAPSHOT.jar","-Dspring.profiles.active=docker", "-Dspring.data.mongodb.uri=mongodb://mongo-db:27017/stock-trading-user", ""-Djava.security.egd=file:/dev/./urandom""]