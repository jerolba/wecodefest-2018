### Latencias y bloqueos

0.- En el directorio `wecode-sleep` lanza esta aplicacón en un terminal nuevo.

```bash
$ run.sh
```

Dejad la aplicación lanzada durante todo el ejercicio.

1.- Compila y ejecuta la aplicación con

```bash
$ run.sh
```

Espera a que termine el proceso. 

Anotar "Total number of requests" y "Average execution time"

Abrir el fichero `latencies.jfr` con JMC: ¿dónde se está produciendo el Lock?

2.- Corregir y volver a ejecutar.

¿Cuanto mejora el tiempo por request y el número de request?

3.- Imaginemos que no podemos quitar el synchronized de getConnection, pero conseguimos mejorar el pool de conexiones 
y bajamos el tiempo que el recurso compartido está bloequeado.

Bajamos el valor de SHARED RESOURCE TIME a 20 y volvemos a ejecutar.

¿Cuanto mejora el tiempo por request y el número de request? ¿Qué conclusiones podemos sacar?

4.- Subimos el SERVLETS_NUMBER de 10 a 20, a ver si subiendo el número de servlets mejoramos el performance.
Cambiamos y volvemos a ejecutar.
 
¿Cuanto mejora el tiempo por request y el número de request? ¿Qué conclusiones podemos sacar?
 
5.- ¿Qué pasa si bajamos el SERVLETS_NUMBER de 10 a 5?, seguro que va a peor!
Cambiamos y volvemos a ejecutar.
 
¿Cuanto mejora el tiempo por request y el número de request? ¿Qué conclusiones podemos sacar?
 
6.- ¿Y si subimos el nº de cores de la base de datos? 
Cambiamos el valor de WORKER_THREADS de 2 a 4 y volvemos a ejecutar.
 
¿Cuanto mejora el tiempo por request y el número de request? ¿Qué conclusiones podemos sacar?

7.- ¿Y si mejoramos la memoria o disco de la base de datos? 
Cambiamos el valor de QUERY EXECUTION TIME de 400 a 200 y volvemos a ejecutar.
 
¿Cuanto mejora el tiempo por request y el número de request? ¿Qué conclusiones podemos sacar?

Jugar a modificar los distintos parámetros para ver en cada momento cúal es el más limitante en cada momento.



