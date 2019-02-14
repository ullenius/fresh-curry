# Fresh Curry
A Java 11 port of Rest Curry. A simple REST client for receiving up to date currency exchange rates.
Uses Java 11's brand new HTTP-client.

Obtains currency exchange rates in JSON-format from server using
REST and stores them as a POJO (plain old java object).

Made as a school exercise for ITHS' course on web
services in 2019. The port was made 2019-02-14

## Building
* Fresh Curry requires Java 11
* This is a Maven project:
** build a jar-file using 'mvn package'
** build documentation 'mvn javadoc'

## Rest API
https://exchangeratesapi.io/

Thanks to Madis Väin (EST) for the API :)

## Libraries

Uses Google's Gson-library.
