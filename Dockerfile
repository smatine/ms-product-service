FROM fabric8/java-jboss-openjdk8-jdk:1.2.3

ENV JAVA_APP_JAR ms-product-service.jar

ENV JAVA_OPTIONS -Xmx256m -Djava.security.egd=file:///dev/./urandom

EXPOSE 8084

ADD target/ms-product-service.jar /deployments/
