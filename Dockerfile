
FROM maven as build
WORKDIR /build
COPY pom.xml .
COPY src src
RUN mvn clean install

FROM openjdk
COPY --from=build /build/target/ProjectManagement-1.0-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]