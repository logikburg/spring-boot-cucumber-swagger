# Spring-Boot-Swagger-Cucumber-Java-Restful


To deploy please follow below steps.

### To prepare java package file using below command
	
	mvn clean package spring-boot:repackage 

### run spring boot package file using below command

    java -jar target/creditscore-java-0.0.1.jar


For Docker

### prepare image with docker for deployment

    docker build -t spring/creditscore-spring-boot-docker .
    
### run docker for deployment

    docker run -p 8080:8080 -t spring/creditscore-spring-boot-docker


For Swagger

### after running application, run the swagger UI to test apis.

	http://localhost:8080/swagger-ui.html
