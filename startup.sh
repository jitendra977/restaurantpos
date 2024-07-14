#!/bin/bash

# Navigate to the project directory
cd /home/jitu/projects/restaurantpos

# Run the Spring Boot application with the dev profile
mvn spring-boot:run -Dspring-boot.run.profiles=dev
