#!/bin/bash
mvn package
JFR_OPTIONS="-XX:StartFlightRecording=delay=1s,duration=60s,settings=profile,filename=latencies.jfr"
JVM_OPTIONS="-XX:+UnlockDiagnosticVMOptions -XX:+DebugNonSafepoints -XX:+UnlockCommercialFeatures -XX:+FlightRecorder"
JAR="wecode-03-latencies-2018.jar"
MAIN_CLASS="com.jerolba.Latencies"

java $JVM_OPTIONS $JFR_OPTIONS -cp target/$JAR $MAIN_CLASS
