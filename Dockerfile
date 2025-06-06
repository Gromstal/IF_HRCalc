FROM eclipse-temurin:17-jdk AS build
WORKDIR /app
COPY . /app
RUN apt-get update && apt-get install -y gradle
RUN ./gradlew build
RUN ls -l ./build/libs/
FROM eclipse-temurin:17-jdk
COPY --from=build /app/build/libs/HR_Calc-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]