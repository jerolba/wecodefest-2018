call mvn package
SET JFR_OPTIONS=-XX:StartFlightRecording=delay=3s,duration=600s,settings=profile,filename=memoryallocationLong.jfr
SET JVM_OPTIONS=-XX:+UnlockDiagnosticVMOptions -XX:+DebugNonSafepoints -XX:+UnlockCommercialFeatures -XX:+FlightRecorder
SET JAR=wecode-04-memory-allocation-2018.jar
SET MAIN_CLASS=com.jerolba.MemoryAllocation

java -XX:+CMSParallelRemarkEnabled %JVM_OPTIONS% %JFR_OPTIONS% -cp target/%JAR% %MAIN_CLASS%
