FROM eclipse-temurin:21-jdk-alpine AS builder
WORKDIR /app

COPY . .

RUN sed -i 's/\r$//' gradlew
RUN chmod +x gradlew
RUN ./gradlew :app-service:bootJar -x test -x validateStructure

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

COPY --from=builder /app/applications/app-service/build/libs/*.jar task.jar

ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=70 -Djava.security.egd=file:/dev/./urandom"

EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar task.jar"]