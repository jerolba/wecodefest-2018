#!/bin/bash
mvn package
JFR_OPTIONS="-XX:StartFlightRecording=delay=3s,duration=600s,settings=profile,filename=memoryallocationLong.jfr"
JVM_OPTIONS="-XX:+UnlockDiagnosticVMOptions -XX:+DebugNonSafepoints -XX:+UnlockCommercialFeatures -XX:+FlightRecorder"
JAR="wecode-04-memory-allocation-2018.jar"
MAIN_CLASS="com.jerolba.MemoryAllocation"

java -XX:+CMSParallelRemarkEnabled $JVM_OPTIONS $JFR_OPTIONS -cp target/$JAR $MAIN_CLASS
