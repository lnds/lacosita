package cosa.grails

import grails.converters.JSON


class DatoController {


    def randomService


    def create() {
        def codigo = randomService.nextLong()
        def datos = []
        10.times {
            def dato = new Dato(codigo:codigo, nombre: "dato ${codigo}", cuando:new Date()  )
            dato.save()
            datos << dato
            codigo++
        }
        render datos as JSON
    }


    def jsonList() {
        def k = randomService.nextLong()
        def where = Dato.where {
            codigo > k
        }
        def datos = where.list(max:10)
        render datos as JSON
    }

    def list() {
        def k = randomService.nextLong()
        def where = Dato.where {
            codigo > k
        }
        def datos = where.list(max:10)
        [datos:datos]

    }
}
