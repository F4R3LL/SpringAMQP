#SpringAMQP

Basic micro-service messaging throught rabbitmq on docker's containers with auto build/push to dockerhub.

___________________________________________________________________________

	SETUP
	
	  1 - Change repository name, username and passowrd from dockerhub.
	  
	  2 - For simple build without push, just remove <goal>push</goal>

	  ./mvnw clean install

___________________________________________________________________________

[pom.xml]

1)
	<repository>dockerhub_repository/${project.artifactId}</repository>
	<username>dockerhub_username</username>
	<password>dockerhub_password</password>


2)
<executions>
	<execution>
		<id>default</id>
		<phase>install</phase>
		<goals>
			<goal>build</goal>
			<goal>push</goal>
		</goals>
	</execution>
</executions>