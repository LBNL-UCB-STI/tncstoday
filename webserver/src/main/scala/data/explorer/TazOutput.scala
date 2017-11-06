package data.explorer

import play.api.libs.json._

object TazOutput {

  //Output structure
  case class TazGeometry(`type`: String, coordinates: Array[Array[Array[Array[Double]]]])
  case class TazViz(gid: Long, taz: Long, nhood: String, sq_mile: Double, geometry: String)

  //Structure for in memory processing
  case class Coordinates(lat: Double, lon: Double)
  case class Geometry(`type`: String, coordinates: Array[Coordinates])
  case class TazStructure(gid: Long, taz: Long, nhood: String, sq_mile: Double, geometry: Geometry)

  //Structure for statistics
  case class TazStats(taz: Long, day_of_week: Int, time: String, dropoffs: Double, pickups: Double)
  case class TazStatsTotals(taz: Long, day_of_week: Int, dropoffs: Double, pickups: Double)

  implicit val tazGeometryWrites = Json.format[TazGeometry]
  implicit val tazVizWrites = Json.format[TazViz]

  implicit val tazStatsFormat = Json.format[TazStats]
  implicit val tazStatsTotalsFormat = Json.format[TazStatsTotals]
}
