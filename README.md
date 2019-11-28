# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.1.RELEASE/maven-plugin/)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.2.1.RELEASE/reference/htmlsingle/#using-boot-devtools)

### Application Information
The StockerApplication program implements an algorithm to find the best trading window to maximise the profit for
a stock observed over it's varying sock prices throughout a day. The interval for stock price
capture is 1 minute from the time trade window stock market opens till the time it closes for the day.

### Build Steps

 * The StockerApplication program is based on top of a Spring Boot application
 * It uses maven as the build tool
 * Make sure you haven installed on your system to run this application
 * Hit the below command to run the application in the terminal
    mvn spring-boot:run
    
 * You can also run the application in IntelliJ by clicking on the run button in the project toolbar

### Test cases

The StockerApplication program is based on top of a Spring Boot application
 * The test cases are written in the below file using JUnit
    Stocker/src/test/java/com/example/StockerApplicationTests.java
 * To run the test cases hit the below command
    mvn test
