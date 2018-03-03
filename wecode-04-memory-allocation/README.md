### Memoria

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

4.- Ejecutar la aplicación con 

```bash
$ wordCount.sh
```
y conecta JMC al proceso con la opción de `MBean Server` y monitoriza el consumo de memoria.

¿Qué dato está ocupando más recursos de memoria? ¿Cómo lo rebajarías sin cambiar NINGUNA estructura de datos?

Una vez descubierto (con la ayuda del instructor), corregirlo y volver a lanzar wordCount.sh.

Sin perder la anterior pestaña en JMC, contéctate al nuevo proceso y observa el nuevo consumo de memoria. ¿Qué ha pasado con ese dato que ocupaba tantos recursos?!

5.- ¿Qué estructura de datos ahora consume muchas instancias? ¿Podemos deshacernos de ella? 

Vamos a cambiar el código... el mapa ahora lo vamos a definir así:

```java
private Map<String, Map<Integer, Integer>> info = new HashMap<>();
```

Y el método `add` lo vamos a implementar así:

```java
private void add(int line, String word, int idx) {
    int pos = rnd.nextInt(line + 1);
    Map<Integer,Integer> map = info.computeIfAbsent(word, v -> new HashMap<>());
    Integer sum = map.getOrDefault(pos,0);
    map.put(pos, sum+1);
}
```

¿Qué ha pasado con el consumo de memoria? ¿Si guardamos la misma información por qué ocupa menos memoria?

¿Te has fijado en el tiempo de ejecución? ¿Por qué ha bajado? (ejercicio para casa: como varía la presión de memoria)

¿Qué ha pasado con la estructura TreeNode? ¿Qué es? ¿En qué se diferencia del un Node? ¿Por qué ha desaparecido del histograma?






  