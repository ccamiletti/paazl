# paazl
tets paazl company

# Docker containers.

## Create containers 
- [Docker version 19.03.5]
- [docker-compose version 1.23.1]
To create paazl database, we are using Docker-compose to build a mysql container (also an 'adminer container' to have access to the database. you can see the credential in docker-compose.yml).

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

-----------------------------------------------------------------------------------------------------------------------------
# PaazlQuestionsWeb

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 7.3.9.

## Development server

To communicate with our backend, we create a proxy.conf.json file to redirect from "localhost:4200" to "localhost:8080"
Open a terminal console and from /APP_DIRECTORY/paazl-questions-web excute: 

npm run start:proxy

Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding
Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build
Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

## Further help
To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).
