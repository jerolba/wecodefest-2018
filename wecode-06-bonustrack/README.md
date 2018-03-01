### Flame Graphs

Asegúrate de tener declarada la variable de entorno JAVA_HOME!

En Mac algo de esta pinta:

`/Library/Java/JavaVirtualMachines/jdk1.8.0_144.jdk/Contents/Home`

puede que [esto te ayude](http://www.baeldung.com/java-home-on-windows-7-8-10-mac-os-x-linux).

Vete al directorio `jfr-flame-graph` del ejercicio.

Ejecutar el comando que instala las dependencias de JMC en un repositorio local:

```bash
$ ./install-mc-jars.sh
```

Compila `jfr-flame-graph`

```bash
$ mvn clean package
```

Copia uno de los ficheros jfr que se han creado durante el taller al directorio actual, y ejecuta el comando:

```bash
$ ./create_flamegraph.sh -f hot_methods.jfr -i > graph.svg
```

Abre el fichero graph.svg en un navegador!


Ahora ejecuta este comando: 

```bash
$ ./create_stacks.sh -f hot_methods.jfr -i > stacks.txt
```

Accede a esta web [https://jlfwong.github.io/speedscope/](https://jlfwong.github.io/speedscope/)

y arrastra el fichero `stacks.txt` generado sobre la propia página.... Awesómico!!

