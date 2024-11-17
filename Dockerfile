#amd
#FROM openjdk:22-jdk

#aarch
FROM --platform=linux/arm64 openjdk:22-jdk

COPY target/restaurantpos-0.0.1-SNAPSHOT.jar .

EXPOSE 8081

ENTRYPOINT ["java","-jar","restaurantpos-0.0.1-SNAPSHOT.jar"]