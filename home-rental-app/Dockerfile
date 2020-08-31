FROM openjdk:8-jdk-alpine
WORKDIR /back-end
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ./app.jar
COPY data.mv.db .
CMD ["java","-jar","./app.jar"]