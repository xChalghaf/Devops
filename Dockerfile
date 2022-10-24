From openjdk:8
copy ./target/achat-1.8.jar achat-1.8.jar
CMD ["java","-jar","employee-jdbc-0.0.1-SNAPSHOT.jar"]
