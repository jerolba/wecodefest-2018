#!/bin/bash
mvn package
JAR="wecode-sleep-0.0.1-SNAPSHOT.jar"

java -jar target/$JAR
