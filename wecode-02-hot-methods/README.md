### Hot Methods

Compila la aplicación con

```bash
$ mvn package
```

#### 1.- Habilitar Flight Recorder

Arranca la clase HotMethods con tu IDE con los siguientes parámetros, o desde linea de comandos:

```bash
java -XX:+UnlockDiagnosticVMOptions -XX:+DebugNonSafepoints -XX:+UnlockCommercialFeatures -XX:+FlightRecorder -cp target/wecode-02-hot-methods-2018.jar com.jerolba.HotMethods 
```

#### 2.- Iniciar JFR desde Java Mission Control
Arrancar `jmc` y entrar en la opción de "Flight Recorder" para hacer una grabación.

Haz una grabación con los parámetros por defecto y esperar a que termine. Navega por los resultados pero no entres en los detalles.


#### 3.- Iniciar JFR desde comandos

Arrancar el programa como en el primer punto, y desde otro terminal listar los procesos Java en ejecución: 

```bash
$ jcmd
```

Después de obtener el PID del proceso, listar los comandos disponibles:

```bash
$ jcmd {PID} help
```

Iniciar una grabación:

```bash
$ jcmd {PID} JFR.start settings=profile
```

Apunta el número de grabación y espera un tiempo....
Puede haber múltiples grabaciones concurrentemente.

Volcar el resultado de la grabación:

```bash
$ jcmd {PID} JFR.dump filename=hot_methods_jcmd.jfr
```

Parar la grabación:

```bash
$ jcmd {PID} JFR.stop
```

Grabar un tiempo determinado:

```bash
$ jcmd {PID} JFR.start filename=hot_methods_jcmd.jfr settings=profile delay=5s duration=30s
```

El fichero se generará donde lanzaste el comando de `java`, no donde estes ejecutando el comando `jcmd`

Mientras se ejecuta, comprobar como va:

```bash
jcmd {PID} JFR.check
```

Más información de los comandos de jcmd [aquí](https://docs.oracle.com/javacomponents/jmc-5-5/jfr-runtime-guide/comline.htm#JFRRT192)

Localiza el fichero `hot_methods_jcmd.jfr` y abrelo con Java Mission Control



#### 4.- Iniciar JFR desde la linea de comandos

Arranca la misma clase desde linea de comandos o desde tu IDE con los siguientes parámetros:

```bash
java -XX:+UnlockDiagnosticVMOptions -XX:+DebugNonSafepoints -XX:+UnlockCommercialFeatures -XX:+FlightRecorder -XX:StartFlightRecording=delay=4s,duration=60s,settings=profile,filename=hot_methods.jfr -cp target/wecode-02-hot-methods-2018.jar com.jerolba.HotMethods 
```

Esperar a que termine de ejecutarse y abrir el fichero `hot_methods.jfr` que se ha creado.

¿Cual de los métodos te parece mejor? Proponer en qué situaciones es mejor un método u otro.


#### 5.- Analiza el código

Abre en JMC el último fichero generado y selecciona la opción de Method Profiling: ¿Qué clase/método está consumiendo más recursos?

Corrigelo y vuelve a ejecutar el código para descubrir el siguiente problema.

#### 6.- Analiza el código 2

Seguimos teniendo ineficiencias. ¿Donde radica ahora el problema?

Corrigelo y vuelve a ejecutar el código para descubrir el siguiente problema.

#### 7.- Analiza el código 3

Seguimos teniendo ineficiencias. ¿Donde radica ahora el problema?
 
¿Por qué el número de muestras cambia tanto?

Corrigelo y vuelve a ejecutar el código para descubrir el siguiente problema.

Se deja como ejercicio seguir mejorando el código :)
  
