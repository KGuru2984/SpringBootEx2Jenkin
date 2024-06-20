FROM openjdk:19
COPY target/SpringBootJPARepoDemo-0.0.1-SNAPSHOT.jar SpringBootJPARepoDemo-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java","-jar","/SpringBootJPARepoDemo-0.0.1-SNAPSHOT.jar"]