call mvn package
SET JAR=wecode-04-memory-allocation-2018.jar
SET MAIN_CLASS=com.jerolba.WordCount

java -cp target/%JAR% %MAIN_CLASS%