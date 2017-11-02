# GitHub API Tests with Java

## Docs

RestAssred Getting Started: 
https://github.com/rest-assured/rest-assured/wiki/GettingStarted
https://github.com/rest-assured/rest-assured/wiki/Usage#examples

## Json to Java

Generate java:
http://www.jsonschema2pojo.org

You might need to add jackson libs:
https://github.com/rest-assured/rest-assured/issues/788

## Run Tests

 Add [maven-surefire-plugin](https://maven.apache.org/surefire/maven-surefire-plugin/usage.html#) to your pom.xml
    
```
    <build>
        <pluginManagement>
            <plugins>
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-compiler-plugin</artifactId>
                    <configuration>
                        <source>1.8</source>
                        <target>1.8</target>
                    </configuration>
                </plugin>
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-surefire-plugin</artifactId>
                    <version>2.19.1</version>
                </plugin>
            </plugins>
        </pluginManagement>
    </build>
```    
 
Run all tests in GitHubTests class:
```
mvn -Dtest=tests.CreateIssueTests test
```
    
Run all tests in demo_01_junit package:
```
mvn -Dtest=tests.demo_01_junit.* test
```