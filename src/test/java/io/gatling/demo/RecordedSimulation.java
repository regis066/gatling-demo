package io.gatling.demo;

import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class RecordedSimulation extends Simulation {

  private HttpProtocolBuilder httpProtocol = http
    .baseUrl("https://computer-database.gatling.io")
    .inferHtmlResources(AllowList(), DenyList(".*\\.js", ".*\\.css", ".*\\.gif", ".*\\.jpeg", ".*\\.jpg", ".*\\.ico", ".*\\.woff", ".*\\.woff2", ".*\\.(t|o)tf", ".*\\.png", ".*\\.svg", ".*detectportal\\.firefox\\.com.*", ".*\\.js", ".*\\.css", ".*\\.gif", ".*\\.jpeg", ".*\\.jpg", ".*\\.ico", ".*\\.woff", ".*\\.woff2", ".*\\.(t|o)tf", ".*\\.png", ".*\\.svg", ".*detectportal\\.firefox\\.com.*"))
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate, br")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:132.0) Gecko/20100101 Firefox/132.0");
  
  private Map<CharSequence, String> headers_0 = Map.ofEntries(
    Map.entry("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"),
    Map.entry("Priority", "u=0, i"),
    Map.entry("Sec-Fetch-Dest", "document"),
    Map.entry("Sec-Fetch-Mode", "navigate"),
    Map.entry("Sec-Fetch-Site", "none"),
    Map.entry("Sec-Fetch-User", "?1"),
    Map.entry("Upgrade-Insecure-Requests", "1")
  );
  
  private Map<CharSequence, String> headers_1 = Map.ofEntries(
    Map.entry("Content-Type", "application/json; charset=utf-8"),
    Map.entry("Priority", "u=4"),
    Map.entry("Sec-Fetch-Dest", "empty"),
    Map.entry("Sec-Fetch-Mode", "cors"),
    Map.entry("Sec-Fetch-Site", "same-origin"),
    Map.entry("X-McAfee-ClientID", "f2c476e4-9eda-42a6-8218-d3f0964d8e93"),
    Map.entry("X-McAfee-Flag", "0"),
    Map.entry("X-McAfee-ProductID", "200200"),
    Map.entry("X-McAfee-ProductVersion", "8.1.0.4975"),
    Map.entry("authorization", "Bearer eyJhbGciOiJSUzUxMiIsImtpZCI6ImNzcCIsInR5cCI6IkpXVCJ9.eyJjc3BpIjoiZTg3YzczZGUtYjQ1ZS00NDI3LWI1OTAtNTEyNDQwMTc5NWI2IiwiYXVkIjoiZTg3YzczZGUtYjQ1ZS00NDI3LWI1OTAtNTEyNDQwMTc5NWI2IiwiYXpwIjoiZTg3YzczZGUtYjQ1ZS00NDI3LWI1OTAtNTEyNDQwMTc5NWI2IiwianRpIjoiYzJhNmQ4MGItYzE2OS00ODQ1LWE4NjgtNzg5MWQyNTAxYTgyIiwiYW1yIjoiY2xpZW50X2NyZWRlbnRpYWxzIiwibmJmIjoxNzI5MTQ4Mzk4LCJleHAiOjE3MjkyMzQ3OTgsImlhdCI6MTcyOTE0ODM5OCwiaXNzIjoiY3NwIn0.MubQDBulR2AOS1tnYtgzT1Jo2A8q0NG1rDiJ9WfqG2h40GYQQS6OnUrEGnzuXqlE7fIdYYFySySvpruHM8ouoUN6ln2pXjvjIhLElbjopR-gU_e_GStnt-rlE03ulDjtZx3YDZUqNdFhwOOfHG_O8zcLimwGLLfCmVug3KTjmjh6N_Y-k2wzcX41znyLtoySkDPepJuYDXrEuWwNKQGZbvpavBlud8dbzeOa9uygG8V9C4VW4lzQ3KoJ-mLlCxBPZZ4bi8NEpwd-_5VlXNBFTzEnNnpQb1tVyf1P0Bp_UcGGajMFNT5md0vs6UP-xaj7lgNn7LIhhzN1OF23XKx0Kg")
  );
  
  private Map<CharSequence, String> headers_3 = Map.ofEntries(
    Map.entry("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"),
    Map.entry("Priority", "u=0, i"),
    Map.entry("Sec-Fetch-Dest", "document"),
    Map.entry("Sec-Fetch-Mode", "navigate"),
    Map.entry("Sec-Fetch-Site", "same-origin"),
    Map.entry("Sec-Fetch-User", "?1"),
    Map.entry("Upgrade-Insecure-Requests", "1")
  );
  
  private Map<CharSequence, String> headers_12 = Map.ofEntries(
    Map.entry("Accept", "application/json"),
    Map.entry("Content-Type", "application/json")
  );
  
  private Map<CharSequence, String> headers_13 = Map.ofEntries(
    Map.entry("Content-Type", "application/json"),
    Map.entry("Origin", "moz-extension://9a054f61-79bc-4d3f-9f36-ed8b392e34ac"),
    Map.entry("Priority", "u=4"),
    Map.entry("Sec-Fetch-Dest", "empty"),
    Map.entry("Sec-Fetch-Mode", "cors"),
    Map.entry("Sec-Fetch-Site", "same-origin"),
    Map.entry("ac", "Q1RCSEdtTnI2Qy9HVG1YeWgxeVQzSlIrNktURVNFZWF3V25weGY3dFQrU2FZQWpONk1rWFZIYnY5ektiZ25MVloyL2xNMDhiSGVUYlNtRmdFNmFtRnR1MmRydTZ0ZnloaFBjbmg3WE0wL1JCSk5jVnkwMGYxZXFwbURNRGpXaGZObDRKaTBOa2FJTEFBZVhndmFpanVjUi9Sd2dKKzRDMGlYSU5FTGxTK3lwK3N3blNXY3MxaU5Gb0lmMDdyc0pnbjhCUlVFYWtNRFlZWnJBTHpRMXlWWGJIWEhpNTVEU0UrTnJ1UjZNbVA5UGFsNHV4Wkc2aEFWRktrUGtaZ3VLd1ZVNzVPWm9tZUl5aTB6cE9QWnh6dklDcGdDc0VJTjRZQTkzWC9SOTFSWkR6L2V4QTJYN2RudC9RYmg3UndPeFA4TEtYNmdpcmgxT2tqSWVoNlJxQkhwRWR3ZUVwNnk1WGxQU3NyUlVZVTE2a3NIZjNWVUhwM3VJS1V6aTBmc1dMYUFlZC95czdBTWlWY0lxOGhvMXBuOHlpVStjZWZFMXluRFRmUGIzNDg5Q0pxWitsSTd4VG1qd3BKSVBYUWZ0OTlyYzh0QQ=="),
    Map.entry("ak", "80FC43F1E6A84731BB8E9157FFA524A8WEB"),
    Map.entry("cd", "e87c73de-b45e-4427-b590-5124401795b6"),
    Map.entry("st", "1"),
    Map.entry("sv", "V1")
  );
  
  private Map<CharSequence, String> headers_18 = Map.ofEntries(
    Map.entry("Content-Type", "application/json; charset=utf-8"),
    Map.entry("Priority", "u=4"),
    Map.entry("Sec-Fetch-Dest", "empty"),
    Map.entry("Sec-Fetch-Mode", "cors"),
    Map.entry("Sec-Fetch-Site", "same-origin"),
    Map.entry("X-McAfee-ClientID", "f2c476e4-9eda-42a6-8218-d3f0964d8e93"),
    Map.entry("X-McAfee-Flag", "0"),
    Map.entry("X-McAfee-ProductID", "200200"),
    Map.entry("X-McAfee-ProductVersion", "8.1.0.4975"),
    Map.entry("authorization", "Bearer eyJhbGciOiJSUzUxMiIsImtpZCI6ImNzcCIsInR5cCI6IkpXVCJ9.eyJjc3BpIjoiZTg3YzczZGUtYjQ1ZS00NDI3LWI1OTAtNTEyNDQwMTc5NWI2IiwiYXVkIjoiZTg3YzczZGUtYjQ1ZS00NDI3LWI1OTAtNTEyNDQwMTc5NWI2IiwiYXpwIjoiZTg3YzczZGUtYjQ1ZS00NDI3LWI1OTAtNTEyNDQwMTc5NWI2IiwianRpIjoiYjYyNDQwM2MtZjc4MC00YmZlLTk1YTctMDY4Yjg5YmJhMTg3IiwiYW1yIjoiY2xpZW50X2NyZWRlbnRpYWxzIiwibmJmIjoxNzMxMzI2Njg5LCJleHAiOjE3MzE0MTMwODksImlhdCI6MTczMTMyNjY4OSwiaXNzIjoiY3NwIn0.PFMSq--2qmAXsdPV5Q4PL-465sR3oFLAYSeXNa-Eb8kU2amXCeJm2t2icm5z4cHoL9VQVkwxVjDqGhUVBAmMTTFfoJL1fHoIkTkLNOCvUBmid4I08T1aslP94f6XwTFYTWEe1wKLdVPW49ivu0qp3vSueP1G4NuYzqsdQcXlhBLAj5kQtiWkfvh7FxZW4MsNs0jhIlKCEll8_JFX7GY-Yf7s23vRdwChFGip0IrnDQZ5JDDx1CpPBu26UAYXEO14aiPrEn8RpXCFiu4CxU5Z1IaACtzvR36pJm5qksY4oSgQ0TV_-A5IQfS_wIn6CUQEJDh8C7yn6P3pAxB1vlFpFQ")
  );
  
  private Map<CharSequence, String> headers_25 = Map.of("Priority", "u=4");
  
  private Map<CharSequence, String> headers_26 = Map.ofEntries(
    Map.entry("Priority", "u=4"),
    Map.entry("content-type", "application/json")
  );
  
  private Map<CharSequence, String> headers_27 = Map.ofEntries(
    Map.entry("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"),
    Map.entry("Origin", "https://computer-database.gatling.io"),
    Map.entry("Priority", "u=0, i"),
    Map.entry("Sec-Fetch-Dest", "document"),
    Map.entry("Sec-Fetch-Mode", "navigate"),
    Map.entry("Sec-Fetch-Site", "same-origin"),
    Map.entry("Sec-Fetch-User", "?1"),
    Map.entry("Upgrade-Insecure-Requests", "1")
  );
  
  private String uri2 = "https://spocs.getpocket.com/spocs";
  
  private String uri3 = "https://content-signature-2.cdn.mozilla.net/chains";
  
  private String uri4 = "https://contile.services.mozilla.com/v1/tiles";
  
  private String uri5 = "https://firefox-settings-attachments.cdn.mozilla.net/main-workspace/tracking-protection-lists";
  
  private String uri6 = "https://threat.api.mcafee.com/network/v1";
  
  private String uri7 = "https://csptoken.ccs.mcafee.com/auth/token";
  
  private String uri8 = "https://firefox.settings.services.mozilla.com/v1/buckets/main/collections";

  private ScenarioBuilder scn = scenario("RecordedSimulation")
    .exec(
      // Search,
      http("request_0")
        .get("/")
        .headers(headers_0)
        .resources(
          http("request_1")
            .get(uri6 + "/query/url/aHR0cHM6Ly9jb21wdXRlci1kYXRhYmFzZS5nYXRsaW5nLmlvL2NvbXB1dGVycw==")
            .headers(headers_1),
          http("request_2")
            .get(uri6 + "/query/url/aHR0cHM6Ly9jb21wdXRlci1kYXRhYmFzZS5nYXRsaW5nLmlvLw==")
            .headers(headers_1)
        ),
      pause(11),
      http("request_3")
        .get("/computers?f=macbook")
        .headers(headers_3),
      pause(4),
      http("request_4")
        .get("/computers/6")
        .headers(headers_3),
      pause(9),
      // Browse,
      http("request_5")
        .get(uri5 + "/eabbc7a1-7d96-4dbd-a886-900c3e9117a0")
        .resources(
          http("request_6")
            .get("/computers")
            .headers(headers_3),
          http("request_7")
            .get(uri5 + "/07a01519-0176-4377-8c21-aaa2be49e569"),
          http("request_8")
            .get(uri5 + "/3a20bb3d-001c-4a2c-be10-78867305dbc8"),
          http("request_9")
            .get(uri5 + "/0ebc86f9-951e-47e2-b459-eb85ab909b10"),
          http("request_10")
            .get(uri5 + "/eb47e255-317e-40f0-9114-e7533f92446a")
        ),
      pause(2),
      http("request_11")
        .get("/computers?p=1")
        .headers(headers_3),
      pause(3),
      http("request_12")
        .get(uri8 + "/normandy-recipes-capabilities/changeset?_expected=1731283264049&_since=%221729025100900%22")
        .headers(headers_12)
        .resources(
          http("request_13")
            .post(uri7)
            .headers(headers_13)
            .body(RawFileBody("io/gatling/demo/recordedsimulation/0013_request.json")),
          http("request_14")
            .get("/computers?p=2")
            .headers(headers_3)
        ),
      pause(3),
      http("request_15")
        .get("/computers?p=3")
        .headers(headers_3)
        .resources(
          http("request_16")
            .get(uri3 + "/remote-settings.content-signature.mozilla.org-2024-12-27-18-19-47.chain"),
          http("request_17")
            .get(uri8 + "/cfr/changeset?_expected=1730491580785&_since=%221729012259301%22")
            .headers(headers_12),
          http("request_18")
            .get(uri6 + "/cache/url-evergreen")
            .headers(headers_18),
          http("request_19")
            .get(uri8 + "/nimbus-desktop-experiments/changeset?_expected=1731094966129&_since=%221729126635191%22")
            .headers(headers_12),
          http("request_20")
            .get(uri8 + "/tracking-protection-lists/changeset?_expected=1731056517359&_since=%221728375418004%22")
            .headers(headers_12),
          http("request_21")
            .get(uri3 + "/remote-settings.content-signature.mozilla.org-2024-12-07-16-25-46.chain"),
          http("request_22")
            .get(uri8 + "/devtools-compatibility-browsers/changeset?_expected=1730875036538&_since=%221726816023452%22")
            .headers(headers_12),
          http("request_23")
            .get(uri8 + "/newtab-wallpapers-v2/changeset?_expected=1729618200384&_since=%221721068497119%22")
            .headers(headers_12)
        ),
      pause(5),
      // Edit,
      http("request_24")
        .get("/computers/new")
        .headers(headers_3),
      pause(23),
      http("request_25")
        .get(uri4)
        .headers(headers_25)
        .resources(
          http("request_26")
            .post(uri2)
            .headers(headers_26)
            .body(RawFileBody("io/gatling/demo/recordedsimulation/0026_request.json"))
        ),
      pause(6),
      http("request_27")
        .post("/computers")
        .headers(headers_27)
        .formParam("name", "Lenovo Think Book G2 ITL")
        .formParam("introduced", "")
        .formParam("discontinued", "")
        .formParam("company", "35")
    );

  {
	  setUp(scn.injectOpen(atOnceUsers(1))).protocols(httpProtocol);
  }
}
