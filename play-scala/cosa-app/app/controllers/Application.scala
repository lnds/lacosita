package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json._
import scala.concurrent.Future

// Reactive Mongo imports
import reactivemongo.api._
import reactivemongo.api.indexes._

// Reactive Mongo plugin, including the JSON-specialized collection
import play.modules.reactivemongo.MongoController
import play.modules.reactivemongo.json.collection.JSONCollection


import org.joda.time.DateTime
import models._
import models.JsonFormats._


object Application extends Controller with MongoController {

  val collection = db[JSONCollection]("dato")
  collection.indexesManager.ensure {
    Index(List("codigo" -> IndexType.Ascending), unique = true)
  }

  def create = Action {  request =>

      var datos = for (i <- 1 to 10) yield {
        val codigo = scala.util.Random.nextLong()
        val dato = Dato(
            codigo,
            "dato "+codigo,
           new java.util.Date())
        collection.insert(dato)
        dato
      }
      Ok(Json.toJson(datos))
  }


  def jsonList = Action { implicit request =>
    Async {
      val k = scala.util.Random.nextLong()

      val query = Json.obj("codigo" -> Json.obj("$gt"->k))
      val opts = QueryOpts().batchSize(10)

      val cursor : Cursor[Dato] = collection.find(query).options(opts).cursor[Dato]
     
      val datosList : Future[List[Dato]] = cursor.toList(10)
      datosList.map { datos =>
        Ok(Json.toJson(datos))
      }
    }
  }

  def list = Action { implicit request =>
    Async {
      val k = scala.util.Random.nextLong()

      val query = Json.obj("codigo" -> Json.obj("$gt"->k))
      val opts = QueryOpts().batchSize(10)

      val cursor : Cursor[Dato] = collection.find(query).options(opts).cursor[Dato]

      cursor.toList(10).map {
        datos =>
          Ok(views.html.index(datos))
      }
    }
  }

}