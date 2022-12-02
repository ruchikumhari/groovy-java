# Java & Maven details
Java version: 1.8.0_302
Maven version: 3.2.5
Groovy: 4.0.6

# Project creation
mvn archetype:generate -DgroupId=com.example -DartifactId=mvn-groovy-test-example -DinteractiveMode=false
mvn clean install eclipse:clean eclipse:eclipse

# Resources
https://stackoverflow.com/questions/4971566/create-eclipse-groovy-java-project-with-maven

# Build
mvn clean install

# Run CMD
java -cp mvn-groovy-test-example-1.0-jar-with-dependencies.jar; com.example.App %* 
