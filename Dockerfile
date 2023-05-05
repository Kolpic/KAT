# Start with a parent image or so called base image, it's a Docker image that your image is based on
# We choose the base image, depending on which tools we need
FROM openjdk:17-jdk-slim
EXPOSE 8080
# We copy the application files into the image with the help of the jar file
COPY target/kat-app.jar app.jar
# Setting working directory in the container
WORKDIR /app
# We need to set the default command that will be run when the container starts
ENTRYPOINT ["java","-jar","/app.jar"]