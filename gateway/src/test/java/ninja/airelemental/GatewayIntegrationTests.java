package ninja.airelemental;

public class GatewayIntegrationTests {
}

// still uses @RunWith(SpringRunner.class)

// @SpringBootTest for integration testing, starts the full application context including the server, unlike WebMvc
// Does not filter Annotations but scans them all.
// Usually has extra parameters
// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

// @AutoConfigureMockMvc - simulates calling the code from the client exactly like a really HTTP request

// TestRestTemplate works with integration testing by allowing test case to consume a REST API
// @Autowired
// private TestRestTemplate restTemplate; // provided automatically by Spring.

// ResponseEntity<List> response = this.restTemplate.getForEntity("http://localhost:" + port + "/user", List.class);
// getForEntity invokes a request on an API, and the response is converted and stored in the variable "response"

// assertThat(reach out to get the info out of response, set the information you are expecting here);
// example: assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

// DBUnit - pre-populate and cleanup databases
// WireMock - Simulates third party API responses.


