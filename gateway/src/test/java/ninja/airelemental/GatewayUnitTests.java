package ninja.airelemental;

public class GatewayUnitTests {


}

// Mezaros (MES) 4 phase structure.
// Setup: Pre reqs needed for the test to successfully run.
// Execution: Invocation of the class/method under test. Could be one test per method if it is large and complicated.
// Verification: Assertion of the result returned from the method under test. Should be verifying the object returned as well as the data.
//              VALIDATION is as important as code coverage. Just having "notnull" is often not enough.
// Teardown: Clearing of any data and fixtures created at setup including persistent data and releasing resources like database connections. Includes deleting any files created.



// Given: Gateway will direct authenticated traffic with a session token in the header
// Given receives the context and passes it to When.
// Create an instance of the system under test(object to be tested), also called a "fixture".

// When: User successfully authenticates against the login page.
// When receives the context, performs one or more actions, and passes the result to Then.
// Invoke the methods of the system under test. This represents specific behavior the test will verify.
// Often a single method with the outcome stored in local variables.

// Then: The Security config will verify the user and token against the Redis server.
// Then receives the result and checks it against the expectations.
// Verify the expected behavior/outcome is obtained. This could be a single assert or a single concept.
