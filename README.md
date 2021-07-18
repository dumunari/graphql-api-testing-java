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
|  +------ models
|  +--------  Breed.java
|  +--------  Dog.java
|  +--------  DogophQL.java
|  +--------  Puppy.java
+-- test
|  +-- java
|  +---- runner
|  +------ RunnerTest.java
|  +---- step_definitions
|  +------ base
|  +-------- BaseSteps.java
|  +------ commons
|  +-------- CommonSteps.java
|  +------ hooks
|  +-------- Hooks.java
|  +---- BreedsSteps.java
|  +---- DogsSteps.java
|  +---- PuppiesSteps.java
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

- Inside the ```src/main/java/models``` package we have all models to help us when calling the GraphQL API.
Those include an GraphQL Schema object and all queries and mutations inside each specific objects.

- Inside the ```src/test/java/runner``` package we have our RunnerTest which is responsible for running our
 scenarios according to our cucumber options.
 
- Inside the ```src/test/java/step_definitions``` package we have our step definitions implementations.
 
- Inside the ```src/test/java/resources``` package we have our ```cucumber.properties``` file with cucumber runner configurations.

- Inside the ```src/test/java/resources/features``` package we have our gherkin feature files.

- Inside the ```src/test/java/resources/reports``` package we have our report files.

## Running the project

- Running all scenarios: ```mvn test```

- Running scenarios by tags: ```mvn test -Dcucumber.filter.tags="@Breeds"```

- Running all scenarios except those with tag @Breeds: ```mvn test -Dcucumber.filter.tags="not @Breeds"```

- Running all scenarios with tags @Breeds or @Dogs: ```mvn test -Dcucumber.filter.tags="@Breeds or @Dogs"```

- Running all scenarios with tags @Puppies and @Dogs: ```mvn test -Dcucumber.filter.tags="@Puppies and @Dogs"```

- Running all scenarios with tag @Puppies only, excluding those tagged with @Puppies and @Dogs: ```mvn test -Dcucumber.filter.tags="@Puppies and not @Dogs"```