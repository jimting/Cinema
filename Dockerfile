FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD cinema-1.jar app.jar
RUN chmod 755 chromedriver
RUN apt-get update
RUN apt-get install -y chromium-driver
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]