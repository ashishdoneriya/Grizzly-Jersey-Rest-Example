# Grizzly-Jersey-Rest-Example
A little example of a rest service using Jersey, Jackson, JAXB and Grizzly. 
uses maven for build

under bin there is a pipe delimited description of the rest calls that would
be made into the service with an example curl command

## To run without lots of config fun
  - mvn clean install install in the app directory
  - mvn dependency:copy-dependencies
  - java -cp target/jersey-example-1.0-SNAPSHOT.jar:target/dependency/* com.eenzee.example.App
