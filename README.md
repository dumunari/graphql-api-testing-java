# GraphQL Api Testing - Java
Application created to test an GraphQL API.

## GraphQL API
https://github.com/dumunari/dogophql

## Dependencies
- https://github.com/cucumber/cucumber-jvm
- https://github.com/rest-assured/rest-assured
- https://github.com/FasterXML/jackson
- https://github.com/cdimascio/dotenv-java

## Project Structure

```
.
+-- src
|  +-- main
|  +---- java
|  +------ api
|  +--------  schema
|  +--------  DogophQL.java
+-- test
|  +-- java
|  +---- resources
|  +------ base
|  +-------- BaseResource.java
|  +------ common
|  +-------- CommonResource.java
|  +------ BreedResource.java
|  +------ DogResource.java
|  +------ PuppyResource.java
|  +---- runner
|  +------ RunnerTest.java
|  +---- step_definitions
|  +------ commons
|  +-------- CommonSteps.java
|  +------ hooks
|  +-------- Hooks.java
|  +------ BreedsSteps.java
|  +------ DogsSteps.java
|  +------ PuppiesSteps.java
|  +-- resources
|  +---- reports
|  +------ reports.html
|  +------ reports.json
|  +---- features
|  +------ breeds.features
|  +------ dogs.features
|  +------ puppies.features
|  +---- cucumber.properties
+-- .env
+-- pom.xml
.
```

- Inside the ```src/main/java/api.schema``` package we have our api schema to help us when calling the GraphQL API.

- Inside the ```src/test/java/runner``` package we have our RunnerTest which is responsible for running our
 scenarios according to our cucumber options.
 
- Inside the ```src/test/java/step_definitions``` package we have our step definitions implementations.
 
- Inside the ```src/test/java/resources``` package we have our API resources to remove api calls logic from our step definitions.

- Inside the ```src/test/resources``` package we have our ```cucumber.properties``` file with cucumber runner configurations.

- Inside the ```src/test/resources/features``` package we have our gherkin feature files.

- Inside the ```src/test/resources/reports``` package we have our report files.

## Running the project

- Running all scenarios: ```mvn test```

- Running scenarios by tags: ```mvn test -Dcucumber.filter.tags="@Breeds"```

- Running all scenarios except those with tag @Breeds: ```mvn test -Dcucumber.filter.tags="not @Breeds"```

- Running all scenarios with tags @Breeds or @Dogs: ```mvn test -Dcucumber.filter.tags="@Breeds or @Dogs"```

- Running all scenarios with tags @Puppies and @Dogs: ```mvn test -Dcucumber.filter.tags="@Puppies and @Dogs"```

- Running all scenarios with tag @Puppies only, excluding those tagged with @Puppies and @Dogs: ```mvn test -Dcucumber.filter.tags="@Puppies and not @Dogs"```