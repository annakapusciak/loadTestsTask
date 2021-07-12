package simulations

import simulations.Helpers.{getAsDoubleOrElse, getAsIntOrElse, getAsStringOrElse}

object PerfTestConfig {
  val baseUrl: String = getAsStringOrElse("baseUrl", "https://computer-database.gatling.io")
  val durationSeconds: Double = getAsDoubleOrElse("durationSeconds", 15.0)
  val numberOfUsers: Int = getAsIntOrElse("numberOfUsers", 1000)
  val meanResponseTimeMs: Int = getAsIntOrElse("meanResponseTimeMs", 1000)
  val maxResponseTimeMs: Int = getAsIntOrElse("maxResponseTimeMs", 2000)
}