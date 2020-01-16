package ninja.airelemental;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class ServicesUnitTests {

    @ActiveProfiles("test")
    @RunWith(SpringJUnit4ClassRunner.class)
    @SpringBootTest(classes = ResourceApplication.class)  // replaces @SpringApplicationConfiguration
    public class MessageServiceUnitTest {



    }

    // Given: Gateway will direct authenticated traffic with a session token in the header
    // When: User successfully authenticates against the login page.
    // Then: The Security config will verify the user and token against the Redis server.

    // Given: Angular REST service from UI will call "Message" (MockMvc?)
    // When: UI page is served
    // Then: UI page should display a header, a UUID from "Message", and a content string from "Message"

    // Given: Angular REST service from Admin will call "Change" (MockMvc?)
    // When: Admin page is Submitted with content information
    // Then: Change will /POST the updated information, Admin page will display UUID from Message and New Content.



}
