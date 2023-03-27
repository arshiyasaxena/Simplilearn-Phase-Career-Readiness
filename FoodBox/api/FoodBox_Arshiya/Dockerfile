FROM openjdk:8-jdk-alpine

RUN mkdir -p /usr/src/app

WORKDIR /usr/src/app

COPY target/FoodBox_CareerReadiness.jar /usr/src/app

EXPOSE 7070

CMD [ "java", "-jar", "FoodBox_CareerReadiness.jar" ]
