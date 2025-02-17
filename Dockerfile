# Use OpenJDK 21 as the base image for building
FROM openjdk:21-jdk-slim AS build

# Install Maven
RUN apt-get update && apt-get install -y maven

# Set working directory
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the entire project
COPY . .

# Package the application
RUN mvn clean install -DskipTests

# Use a lightweight image to run the application
FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the previous build stage
COPY --from=build /app/target/plagiarism-checker-0.0.1-SNAPSHOT.jar plagiarism-checker.jar

# Expose the port on which the application will run
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "plagiarism-checker.jar"]
