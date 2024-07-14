#!/bin/bash

<<<<<<< HEAD
# Define the project directory
PROJECT_DIR="/home/jitu/projects/restaurantpos"

# Navigate to the project directory
cd "$PROJECT_DIR" || { echo "Failed to navigate to project directory: $PROJECT_DIR"; exit 1; }

# Run the Spring Boot application with the dev profile
mvn spring-boot:run -Dspring-boot.run.profiles=dev
if [ $? -ne 0 ]; then
    echo "Failed to start the Spring Boot application"
    exit 1
fi

echo "Spring Boot application started successfully with the dev profile"
=======
# Change directory to the project folder
cd ~/projects/restaurantpos

# Run the Spring Boot application using Maven
nohup mvn spring-boot:run &

>>>>>>> 8117658 (Committing changes)
