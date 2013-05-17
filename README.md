Mini Benchmark de Frameworks
============================

La idea es probar algunos frameworks de desarrollo web con algunos casos de usos distintos a los tradicionales.

El ejercicio consiste en lo siguiente:

* Crear una aplicación web que use MongoDB como base de datos.
* La aplicación proporciona tres funciones: crear, listar, y desplegar.
* Crear crea 10 entidades distintas en la base mongodb. Las entidades creadas se devuelven como una lista JSON.
* Listar selecciona 10 entidades al azar de la base de datos y la devuelve como una lista JSON.
* Desplegar sirve para probar el mecanismo de composición de páginas (templates), en este caso debe desplegar una página web que use Twitter Bootstrap que muestre una tabla con 10 datos.

Los frameworks a evaluar son:

* Grails
* Play con Scala
* Play con Java

Evaluaremos:

* Performance, mediante la herramienta [wrk](https://github.com/wg/wrk), medida en request/segundo
* Líneas de Código
* Complejidad según la [métrica de Halstead](http://www.programando.org/blog/2013/01/desafio-enero-las-metricas-de-halstead/)
* Tiempo para resolver el problema (medido en horas usadas programando), para esto llevaré una bitácora y haré algunas aproximaciones al tiempo usado en base a los registros de la bitácora.

Los frameworks se evaluarán out of the box.






