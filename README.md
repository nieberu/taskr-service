# taskr-service
The service repository for the Taskr application
This project has been dockerized so that we can ensure that when we deploy we will not run into any issues.  With that being said, you will need to download and install Docker Desktop (https://www.docker.com/products/docker-desktop).

Once installed you can now run the application in a containerized manner.

# Read Me First
The following was discovered as part of building this project:

* The original package name 'com.daimler.taskr-service' is invalid and this project uses 'com.daimler.taskrservice' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/maven-plugin/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)


# Building the Application
From a terminal at your project level, run the following command:

docker image build -t taskr-service .

This will build a docker image labeled taskr-service

# Running the Service
From a terminal at your project level, run the following command:

docker container run -p 8080:8080 taskr-service

This will start the service on port 8080 of localhost.  To verify it is running, navigate to the following URL in a browser:

http://localhost:8080/swagger-ui.html#/ 

You should see the Swagger page for the project with all the services described

Note: data.sql is used to populate the database on the first launch. Delete that file in order to have a fresh and empty database.