FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY ./build/libs/HR_Calc-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]