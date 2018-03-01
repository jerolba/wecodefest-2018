###Memoria

1.- Compila y ejecuta la aplicación con

```bash
$ run.sh
```

¿Por qué se para a veces la salida por pantalla de las trazas?

Abrir el fichero `memoryallocation.jfr` con JMC en la opción Memory: ¿Qué problemas ves?

¿Qué clases se instancian más? ¿Donde? ¿Por qué?

Apúntate hasta qué iteración ha llegado.

Solucionalo y vuelve a ejecuar la prueba, renombrando el fichero memoryallocation.jfr para poder comparar luego.

Ver cómo se ha reducido la presión de memoria.  

2.- Otra vez: ¿Qué clases se instancian más? ¿Donde? ¿Por qué?
 
Solucionalo y vuelve a ejecuar la prueba, renombrando el fichero memoryallocation.jfr para poder comparar luego.

¿Qué ha pasado con los char[]? ¿Por qué aumenta? Cómo lo solucionamos?

Una vez solucionado (con la ayuda del instructor), vuelve a ejecutarlo conservando el memoryallocation.jfr

¿Qué le está pasando al GC? 


3.- Ejecutar la aplicación con 

```bash
$ longRun.sh
```

En JMC conéctate a la instancia con la opción de `MBean Server`, y pestaña Memory.

¿Qué problema de memoria tenemos? ¿Cómo va creciendo la tendencia del consumo de memoria? ¿Por qué?

¿Qué le pasa a las trazas de la consola? ¿Cuanto ha durado la última recolección de basura?

¿Cómo podemos saber qué objetos estan ocupando más memoria?

Una vez descubierto (con la ayuda del instructor), corregirlo y volver a lanzar longRun.sh.

Volver a monitorizar el consumo de memoria.

  