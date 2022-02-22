FROM openjdk
MAINTAINER nagata
COPY target/dev-specification-0.0.1.jar dev-specification-0.0.1.jar
ENTRYPOINT ["java","-jar","/dev-specification-0.0.1.jar"]