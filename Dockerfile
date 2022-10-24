FROM openjdk:8-jre-alpine
ADD target/achat-2.0-SNAPSHOT.jar achat-2.0-SNAPSHOT.jar
EXPOSE 8089
CMD ["java", "-jar", "/achat-2.0-SNAPSHOT.jar"]
