call mvn package
SET JFR_OPTIONS=-XX:StartFlightRecording=delay=4s,duration=60s,settings=profile,filename=hot_methods.jfr
SET JVM_OPTIONS=-XX:+UnlockDiagnosticVMOptions -XX:+DebugNonSafepoints -XX:+UnlockCommercialFeatures -XX:+FlightRecorder
SET JAR=wecode-01-tools-2018.jar
SET MAIN_CLASS=com.jerolba.JavaTools

java %JVM_OPTIONS% %JFR_OPTIONS% -cp target/%JAR% %MAIN_CLASS%
