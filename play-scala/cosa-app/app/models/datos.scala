package models

import reactivemongo.bson._

case class Dato(
		codigo: Long,
		nombre: String,
		cuando: java.util.Date
	)

object JsonFormats {
	import play.api.libs.json.Json
  	import play.api.data._
  	import play.api.data.Forms._

  	implicit val datoFormat = Json.format[Dato]
}