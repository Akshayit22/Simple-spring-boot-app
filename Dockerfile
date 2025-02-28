# Step 1: Use Maven official image as the build stage
FROM maven:3.8.6-openjdk-17 AS build

# Set working directory inside the container
WORKDIR /app

# Copy the Maven project files to the container
COPY pom.xml .
COPY src ./src

# Build the application using Maven
RUN mvn clean package -DskipTests

# Step 2: Use a lightweight JDK runtime image for running the application
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the built jar file from the Maven build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]


