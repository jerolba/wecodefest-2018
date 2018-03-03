call mvn package
SET JFR_OPTIONS=-XX:StartFlightRecording=delay=4s,duration=30s,settings=profile,filename=hot_methods.jfr
SET JVM_OPTIONS=-XX:+UnlockDiagnosticVMOptions -XX:+DebugNonSafepoints -XX:+UnlockCommercialFeatures -XX:+FlightRecorder
SET JAR=wecode-02-hot-methods-2018.jar
SET MAIN_CLASS=com.jerolba.HotMethods

java %JVM_OPTIONS% %JFR_OPTIONS% -cp target/%JAR% %MAIN_CLASS%
