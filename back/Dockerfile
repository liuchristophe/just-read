FROM maven:3.5.2-jdk-8-alpine as maven
WORKDIR /app
COPY . .
RUN mvn package -DskipTests

FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY --from=maven /app/target/just-read-*.jar /app/target/app.jar
# RUN java -jar target/app.jar
# ENTRYPOINT [ "java", "-jar", "/app/target/just-read-0.0.1-SNAPSHOT.jar" ]
ENTRYPOINT [ "java", "-jar", "/app/target/app.jar" ]