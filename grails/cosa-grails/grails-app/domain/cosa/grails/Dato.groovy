package cosa.grails

import org.bson.types.ObjectId

class Dato {

    ObjectId id
    Long codigo
    String nombre
    Date   cuando


    static mapping = {
        codigo index: true, indexAttributes: [unique: true, dropDups:true]
    }

    static constraints = {
        nombre blank: false
    }

    static mapWith = "mongo"
}
