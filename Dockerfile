FROM openjdk:17-jdk-slim
WORKDIR /usr/app
ADD target/*.jar app.jar
RUN apt-get update && apt-get install -y procps && rm -rf /var/lib/apt/lists/*
ENV JAVA_OPTS=""
EXPOSE 8081
ENTRYPOINT exec java ${JAVA_OPTS} -jar app.jar
