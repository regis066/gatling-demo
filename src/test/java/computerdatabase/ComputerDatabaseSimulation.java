package computerdatabase;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.core.CoreDsl.constantUsersPerSec;
import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.http.HttpDsl.http;

public class ComputerDatabaseSimulation extends Simulation {

    //    Define the protocol class
    HttpProtocolBuilder httpProtocol = http.baseUrl("https://computer-database.gatling.io").acceptHeader("text/html");

    //    Write a scenario
    ScenarioBuilder myScenario = scenario("My Scenario").exec(http("Request 1").get("/computers/"));

    //    Define the injection profile
    {
        setUp(myScenario.injectOpen(constantUsersPerSec(2).during(60))).protocols(httpProtocol);
    }
}