FROM openjdk:8-jdk-alpine

COPY . /usr/creditscore/

WORKDIR /usr/creditscore/

RUN wget https://downloads.apache.org/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz -P /tmp
RUN tar xf /tmp/apache-maven-*.tar.gz -C /opt
#RUN ln -s /opt/apache-maven-3.6.0 /opt/maven

#ENV JAVA_HOME=/usr/bin/java
ENV M2_HOME=/opt/apache-maven-3.6.3
ENV MAVEN_HOME=/opt/apache-maven-3.6.3
ENV PATH=/opt/apache-maven-3.6.3/bin:${PATH}

#RUN apt-get update -y && apt-get install maven -y
RUN mvn clean package spring-boot:repackage

CMD ["java", "-jar", "target/creditscore-java-0.0.1.jar"] 