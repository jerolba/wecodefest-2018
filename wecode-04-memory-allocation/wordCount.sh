#!/bin/bash
mvn package
JAR="wecode-04-memory-allocation-2018.jar"
MAIN_CLASS="com.jerolba.WordCount"

java -cp target/$JAR $MAIN_CLASS
