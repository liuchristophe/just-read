FROM maven:3.5.2-jdk-8-alpine as maven
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:8-jdk-alpine as spring
WORKDIR /app
COPY --from=maven /app/target/just-read-*.jar /app/target/app.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "/app/target/app.jar" ]