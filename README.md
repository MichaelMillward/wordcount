# Word Count

This project is a Java program which takes a path to a file as an argument. 
It reads the file and then prints each word that appears in the file and the number of occurrences of that word. 
It prints these words in descending order (most occurrences to least occurrences).

**Project requirements:**

- JDK 8 or later
- Maven

**How to build:**

To build the project, run the following command from the root of the project: 

```
mvn clean install
```

This will create a JAR in the location target/WordCount-1.0-FINAL.jar.

**How to run:**

If you have a terminal window open within the root of the project, you can run the program with the following command:

```
java -jar target/WordCount-1.0-FINAL.jar [PATH_TO_FILE]
```

A test file exists in the root of the project for your convenience. To run the program on this file, run the following command:

```
java -jar target/WordCount-1.0-FINAL.jar test.txt
```
