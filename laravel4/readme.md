## lacosita en Laravel 4.x

Laravel 4 todavia se encuentra en beta y va a ser lanzado el 28 de mayo.

### Prerequisitos

* PHP 5.4 (ya que utilice los arreglos de la forma [])
* Tener habilitado la extension o [driver de Mongo para PHP](http://docs.mongodb.org/ecosystem/drivers/php/)
* Tener instalado [Composer](http://getcomposer.org/) local o global

### Notas

Laravel 4 todabia no tiene soporte oficial de Mongo, pero hay un package que brinda soporte con el ORM de laravel(Eloquent) pero que no tiene implementado el uso de index y en especial la habilidad de asignar la propiedad ensureIndex. No habia utilizado nunca MongoDB, pero me fije que podia asignarle esta propiedad "a la mala", tomando la propiedad collection (Esto se puede ver en CosaController, linea 10)

### Aclaraciones

El numero aleatorio de N, para asignar el valor a codigo, fue sacado del ejemplo de node.

Las vistas siguieron el patron de los otros ejemplos, usando el template de laravel llamado Blade, separando el menu(navbar) y un template master.

La base datos de Mongo se llama 'cosa-laravel' y la collection 'datos'.

### Ejecucion

Asumiendo que se cuenta con Composer instalado global, se debe actualizar el proyecto para que descargue las dependencias mediante:

`composer install`

Ahora basta iniciar el servidor de PHP (Se creara por defecto en localhost:8000) haciendo uso del comando:

`php artisan serve`

### Rutas de acceso
http://localhost:8000/cosa/create
http://localhost:8000/cosa/list
http://localhost:8000/cosa/json-list
