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
* Play con Java (PENDIENTE)
* NodeJs con Express

Evaluaremos:

* Performance, mediante la herramienta [wrk](https://github.com/wg/wrk), medida en request/segundo
* Líneas de Código
* Complejidad según la [métrica de Halstead](http://www.programando.org/blog/2013/01/desafio-enero-las-metricas-de-halstead/)
* Tiempo para resolver el problema (medido en horas usadas programando), para esto llevaré una bitácora y haré algunas aproximaciones al tiempo usado en base a los registros de la bitácora.

Los frameworks se evaluarán out of the box.


Resultados
==========

Create:

	Grails: 	    91,37 request/sec generando   9.240 inserts
	Scala-Play:   1285,51 request/sec generando 128.640 inserts
	NodeJs:		   898,73 request/sec generando  90.070 inserts

List:

	Grails:		    88,85 request/sec
	Scala-Play:    836,16 request/sec
	NodeJs:        231,35 request/sec


JsonList:

	Grails:	        740,52 request/sec
	Scala-Play:     984,82 request/sec
    NodeJs:        1092,56 request/sec


Lineas de Código:

Grails:


	-------------------------------------------------------------------------------
	Language                     files          blank        comment           code
	-------------------------------------------------------------------------------
	XML                             15             14              0           1000
	CSS                              3            135             23            629
	Groovy                          11             64             52            233
	HTML/GSP                         3             16              0             80
	Javascript                       1              0              0              9
	-------------------------------------------------------------------------------
	SUM:                            33            229             75           1951
	-------------------------------------------------------------------------------


Scala-Play:

	-------------------------------------------------------------------------------
	Language                     files          blank        comment           code
	-------------------------------------------------------------------------------
	CSS                              4            976             42           6276
	Javascript                       2            549            331           1406
	HTML                             3             16              0             74
	Scala                            2             24              2             67
	XML                              1              0              0              6
	-------------------------------------------------------------------------------
	SUM:                            12           1565            375           7829
	-------------------------------------------------------------------------------

NodeJs:

	-------------------------------------------------------------------------------
	Language                     files          blank        comment           code
	-------------------------------------------------------------------------------
	CSS                              5            977             42           6283
	Javascript                       5            570            339           1508
	HTML (Jade)                      4              8              0             61	
	-------------------------------------------------------------------------------
	SUM:                            14           1555            381           7852
	-------------------------------------------------------------------------------
