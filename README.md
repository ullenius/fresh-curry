# Fresh Curry
A Java 11 fork of Rest Curry. A simple REST client for receiving up to date currency exchange rates.
Uses Java 11's brand new HTTP-client.

Obtains currency exchange rates in JSON-format from server using
REST and stores them as a POJO (plain old java object).

Made as a school exercise for ITHS' course on web
services in 2019. The porting (fork) to Java 11 was made on 2019-02-14

## Building
* Fresh Curry requires Java 11
* This is a Maven project:
  * build a jar-file:
  ```
  mvn package
  ```
  * build documentation:
  ```
  mvn javadoc:javadoc

## Rest API
https://exchangeratesapi.io/

Thanks to Madis Väin (EST) for the API :)

## Libraries

Uses Google's Gson-library.
