FROM openjdk:11

COPY target/perrysummervacationmessaging-0.0.1-SNAPSHOT.jar /perry.jar

EXPOSE 8080

CMD ["java", "-jar", "/perry.jar"]
