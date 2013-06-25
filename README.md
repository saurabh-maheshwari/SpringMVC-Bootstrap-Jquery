Spring-Bootstrap-Jquery template project.

Requirements:
1. Java 7
2. Maven 3.0.x

Build:
Project can be built by 
	'mvn clean install' or 'mvn clean install -DskipTests=true' (not project specific)

Deploy:
For testing, Maven can deploy it using tomcat plugin: 'mvn clean tomcat:run'
Or
WAR file can be dropped into tomcat container. If the tomcat is running locally, application will be deployed at 'http://localhost:8080/springmvc-boot-1.0.1/'
