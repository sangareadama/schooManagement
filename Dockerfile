FROM openjdk:8
LABEL maintainer="javaguides.net"
ADD target/schoolManagement-0.0.1-SNAPSHOT.jar schoolManagement.jar
ENTRYPOINT ["java","-jar" ,"/schoolManagement.jar"]