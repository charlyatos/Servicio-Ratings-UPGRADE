FROM openjdk:11
EXPOSE 8080

ADD build/libs/ratings-course-0.0.1-SNAPSHOT.jar /
ENTRYPOINT ["java","-jar","/ratings-course-0.0.1-SNAPSHOT.jar"]
