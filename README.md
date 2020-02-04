# paazl
tets paazl company

# Docker containers.

## Create containers 
- [Docker version 19.03.5]
- [docker-compose version 1.23.1]
To create paazl database, we are using Docker-compose to create a mysql container (also an 'adminer container' to have access to the database. you can see the credential in docker-compose.yml).

to create the containers, please run the follow command

from /APP_DIRECTORY/docker/ : docker-compose -f docker-compose.yml up -d

-----------------------------------------------------------------------------------------------------------------------------

# paazl-test-backend
## Requirements
For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `nl.paazl.PaazlTestBackendApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:


npm install

mvn spring-boot:run
