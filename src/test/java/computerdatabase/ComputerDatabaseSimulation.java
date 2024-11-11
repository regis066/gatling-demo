package computerdatabase;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.FeederBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;

public class ComputerDatabaseSimulation extends Simulation {

    //    Define the protocol class
    HttpProtocolBuilder httpProtocol = http.baseUrl("https://computer-database.gatling.io").acceptHeader("text/html");

    //    Feeders
    FeederBuilder.Batchable<String> feeder = csv("search.csv").random();


    //    Business Processes
    ChainBuilder search =
            exec(http("Home").get("/")).pause(1).feed(feeder).exec(http("Search").get("/computers?f=#{searchCriterion" +
                    "}").check(
                    css("a:contains('#{searchComputerName}')", "href").saveAs("computerUrl")
            )).pause(1).exec(http(
                    "Select").get("#{computerUrl}")).pause(1);

    ChainBuilder browse = null;
    ChainBuilder edit = null;
    
    //    Write a scenario
    ScenarioBuilder users = scenario("Users").exec(search, browse);
    ScenarioBuilder admins = scenario("Admins").exec(search, browse, edit);


    //    Define the injection profile
    {
        setUp(users.injectOpen(rampUsers(10).during(10)), admins.injectOpen((rampUsers(2).during(10)))).protocols(httpProtocol);
    }


}