FROM openjdk:8
ADD target/usuario-0.0.1-SNAPSHOT.jar usuario-0.0.1-SNAPSHOT.jar
EXPOSE 7000
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "usuario-0.0.1-SNAPSHOT.jar"]