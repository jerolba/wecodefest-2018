### JMH

0.- En una carpeta distinta a la de este ejercicio ejecuta:

```bash
$ mvn archetype:generate -DinteractiveMode=false -DarchetypeGroupId=org.openjdk.jmh -DarchetypeArtifactId=jmh-java-benchmark-archetype -DgroupId=com.wecodefest -DartifactId=wecode-05-jmh -Dversion=1.0
```

1.- Ejecución de un benchmark vacío

```bash
$ mvn package
$ java -jar target/benchmarks.jar
```

Visualiza un par de Forks y para el proceso.


2.- Vamos a medir lo que tarda en hacer el logaritmo de Pi

Añade esta implementación al método testMethod de MyBenchmark:

```java
Math.log(Math.PI);
```

Empaqueta y ejecuta:

```bash
$ mvn clean package
$ java -jar target/benchmarks.jar
```

3.- Configura el benchmark

Configura con anotaciones para que
- haga 1 fork
- salga nanosegundos por operación
- caliente durante 3 iteraciones de 2 segundos cada una
- ejercite el código con 4 iteraciones de 500 milisegundos 

```java
@Fork(1)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 3, time = 2, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 4, time = 500, timeUnit = TimeUnit.MILLISECONDS)
```

4.- Optimizaciones

¿No ha tardado demasiado poco? Vamos a añadirle algo con lo que comparar, un baseline:

Añade este método a MyBenchmark:

```java
@Benchmark
public void baseline() {
}
```

Y vuelve a compilar y ejecutar los benchmarks. Ahora ejecutará los dos benchmarks.

¿Qué diferencia de tiempo hay entre ellos? ¿Por qué tarda parecido?

Modifica el benchmark para que "consuma" el número y no lo optimice.
 
```java
    public void testMethod(Blackhole bh) {
        bh.consume(Math.log(Math.PI));
    }
```
y ejecútalo otra vez.

Es equivalente a devolver el valor. Añade esta implementación:
 
```java
    public double testMethodReturn() {
        return Math.log(Math.PI);
    }
```
y ejecútalo otra vez.

¿Cuando conviene usar uno u otro?


5.- El setup del Benchmark

Crea una clase llamada `CountWordsBenchmark` con este código:


```java
package com.wecodefest;

import java.io.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openjdk.jmh.annotations.*;

@Fork(1)
@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
@Warmup(iterations = 4, time = 2, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 8, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
public class CountWordsBenchmark {

    private List<String> lines;

    @Setup
    public void readBook() {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("ElQuijote.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        lines = br.lines().collect(Collectors.toList());
    }

}
```

E implementa dos benchmarks que cuenten palabras (separador es " "):
 - Haciendo todo con streams
 - Iterando la colección con un for de forma clásica

Para limitarnos a esta clase ejecuta el benchmark con: 

```bash
$ java -jar target/benchmarks.jar CountWordsBenchmark
```

¿Qué implementación es más rápida?


6.- Benchmark parametrizado


Modificar el código con este nuevo atributo parametrizado y el nombre del Resource cargado. 

```java

    @Param({"ElQuijote.txt","DonJuanTenorio.txt"})
    private String fileName;

    @Setup
    public void readBook() {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(fileName);
```