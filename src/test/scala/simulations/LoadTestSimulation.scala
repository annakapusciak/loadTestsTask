package simulations

import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder
import io.gatling.http.request.builder.HttpRequestBuilder.toActionBuilder
import simulations.PerfTestConfig.{baseUrl, durationSeconds, maxResponseTimeMs, meanResponseTimeMs}

import scala.concurrent.duration.DurationDouble
import scala.language.postfixOps

class LoadTestSimulation extends Simulation {

  val httpConf: HttpProtocolBuilder = http.baseUrl(baseUrl)
  val getRequest: ScenarioBuilder = scenario("Call Gatling testing endpoint")
    .exec(http("GET endpoint")
      .get("")
      .check(status.is(200))
    )
  setUp(getRequest.inject(
    rampUsers(PerfTestConfig.numberOfUsers) during (durationSeconds seconds))
    .protocols(httpConf))
    .assertions(
      global.responseTime.max.lt(meanResponseTimeMs),
      global.responseTime.mean.lt(maxResponseTimeMs),
      global.successfulRequests.percent.gt(95)
    )
}