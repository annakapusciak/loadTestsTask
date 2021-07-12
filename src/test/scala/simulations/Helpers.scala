package simulations

import scala.sys.SystemProperties

object Helpers {
  val systemProperties = new SystemProperties

  def getAsIntOrElse(property: String, default: Int): Int = {
    systemProperties.getOrElse(property, default).toString.toInt
  }

  def getAsStringOrElse(property: String, default: String): String = {
    systemProperties.getOrElse(property, default)
  }

  def getAsDoubleOrElse(property: String, default: Double): Double = {
    systemProperties.getOrElse(property, default).toString.toDouble
  }
}