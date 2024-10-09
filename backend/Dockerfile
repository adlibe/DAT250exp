FROM gradle:7.6.0-jdk17 AS build
WORKDIR /app
COPY --chown=gradle:gradle . /app
RUN gradle -Porg.gradle.java.home=/usr/lib/jvm/java-21-openjdk-amd64 bootJar --no-daemon

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar /app/app.jar
EXPOSE 8080
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
CMD ["java", "-jar", "/app/app.jar"]

