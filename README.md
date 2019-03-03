# QueryDSL with Spring boot

This is example Spring boot project that uses QueryDSL for building queries. 

## JAXB notice
JAXB is removed from Java 11. If you compile with lower version please remove jaxb dependencies from pom.xml

## How to access H2 console
After you've started application navigate to [H2 console](http://localhost:8080/h2-console)
Just put this to JDBC URL: 
```
jdbc:h2:mem:testdb
```