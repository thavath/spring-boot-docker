# Build Step
FROM maven:3.9.8-amazoncorretto-21-al2023 AS build
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

# Run Step
FROM amazoncorretto:21
ARG PROFILE=dev
ARG APP_VERSION=1.0.1

WORKDIR /app

COPY --from=build /build/target/customers-microservices-*.jar /app/
EXPOSE 8080

ENV ACTIVE_PROFILE=${PROFILE}
ENV JAR_VERSION=${APP_VERSION}

CMD java -jar -Dspring.profiles.active=${ACTIVE_PROFILE} customers-microservices-${JAR_VERSION}.jar