### Java Tools

Lista todos los procesos Java en ejecución con el paquete y nombre de clase principal:

```bash
$ jps -l
```

Mostrar el estado del Garbage Collector cada 1000 milisegundos durante 120 segundos

```bash
$ jstat -gc {PID} 1000 120
```

Mostrar los hilos en ejecución:

```bash
$ jstack {PID}
```

Mostrar información del heap y las generaciones del GC:

```bash
$ jmap -heap {PID}
```

Mostrar un histograma de objetos instanciados y su tamaño en memoria:

```bash
$ jmap -histo {PID}
```

Arrancar Java VisualVM

```bash
$ jvisualvm
```

Conectar con el proceso en ejecución y navegar por las opciones que tiene sin entrar en muchos detalles.

Arrancar JConsole

```bash
$ jconsole
```

Conectar con el proceso en ejecución y navegar por las opciones que tiene sin entrar en muchos detalles.


Arrancar Java Mission Control

```bash
$ jmc
```

Conectar con el proceso en ejecución y navegar por las opciones que tiene sin entrar en muchos detalles.
Entrar por la opción de `MBean Server`.



