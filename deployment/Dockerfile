FROM eclipse-temurin:21-jdk-alpine AS builder
WORKDIR /app

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY . .

RUN chmod +x gradlew
RUN ./gradlew :app-service:bootJar -x test -x validateStructure

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

COPY --from=builder /app/applications/app-service/build/libs/task.jar task.jar

ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=70 -Djava.security.egd=file:/dev/./urandom"

EXPOSE 8080
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar task.jar" ]