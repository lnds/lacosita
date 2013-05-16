package cosa.grails

import grails.converters.JSON


class DatoController {


    def randomService


    def create() {
        def codigo = randomService.nextLong()
        def dato = new Dato(codigo:codigo, nombre: "dato ${codigo}", cuando:new Date()  )
         dato.save()
        render dato as JSON
    }

}
