FROM openjdk:8
ADD target/emprendimiento-0.0.1-SNAPSHOT.jar emprendimiento-0.0.1-SNAPSHOT.jar
EXPOSE 7000
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "emprendimiento-0.0.1-SNAPSHOT.ajr"]