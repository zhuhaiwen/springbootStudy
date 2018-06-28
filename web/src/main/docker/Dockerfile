FROM java:8
ADD moreModule*.jar /data/app/app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java", "-jar", "app.jar"]