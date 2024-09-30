FROM openjdk:22-jdk

COPY target/restaurantpos-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

ENTRYPOINT ["java","-jar","restaurantpos-0.0.1-SNAPSHOT.jar"]