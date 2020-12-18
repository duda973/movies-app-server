FROM java:8

EXPOSE 8080

ADD target/moviedb-api.jar moviedb-api.jar

ENTRYPOINT ["java", "-jar", "moviedb-api.jar"]