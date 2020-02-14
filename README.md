# AnagramsChecker

A anagrams checker server with basic REST API.

Anagram: a word, phrase, or name formed by rearranging the letters of another, such as cinema, formed from iceman.

Valid Input String: only contains character 'a'--'z' || 'A'--'Z' || whitespace

## Built With

* 	[Maven](https://maven.apache.org/) - Dependency Management
* 	[JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java™ Platform, Standard Edition Development Kit 
* 	[Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications
* 	[git](https://git-scm.com/) - Free and Open-Source distributed version control system 

## External Tools Used

* [Postman](https://www.getpostman.com/) - API Development Environment (Testing Docmentation)

## Running the application locally

One way is using maven command

1. cd to root folder of project
2. type 'mvn test' in terminal to run the test in project
3. type 'mvn spring-boot:run' in terminal to run the server
4. access server by URL: http://localhost:8080/anagrams/{string1}/{string2}

************

Another way is to execute the `main` method from your IDE.

- Download the zip or clone the Git repository.
- Unzip the zip file (if you downloaded one)
- Open Command Prompt and Change directory (cd) to folder containing pom.xml
- Open Intellij or Eclipse 
- Choose the Spring Boot Application file (search for @SpringBootApplication)
- Right Click on the file and Run as Java Application

### REST API

|  URL |  Method |
|----------|--------------|
|`http://localhost:8080/anagrams/{string1}/{string2}`  			| GET |

Provided Testing URL:
1. Send request: "localhost/8080/anagrams/asdf/fdsa" => return 200 (HttpStatus.OK) {areAnagrams:true}
2. Send request: "localhost/8080/anagrams/asdf/fff" => return 200 (HttpStatus.OK) {areAnagrams:false}
3. Send request: "localhost/8080/anagrams/asdf/ff_!@#$%f" => return 400 (HttpStatus.BAD_REQUEST) "Input string is invalid"


## packages

- `service` — to hold our anagrams check algorithm;
- `controller` — to listen to the client and provide Rest APIs;
- `test` - contains unit and integration tests

- `pom.xml` - contains all the project dependencies

