#!/bin/bash
mvn package
JFR_OPTIONS="-XX:StartFlightRecording=delay=4s,duration=60s,settings=profile,filename=hot_methods.jfr"
JVM_OPTIONS="-XX:+UnlockDiagnosticVMOptions -XX:+DebugNonSafepoints -XX:+UnlockCommercialFeatures -XX:+FlightRecorder"
JAR="wecode-02-hot-methods-2018.jar"
MAIN_CLASS="com.jerolba.HotMethods"

java $JVM_OPTIONS $JFR_OPTIONS -cp target/$JAR $MAIN_CLASS
