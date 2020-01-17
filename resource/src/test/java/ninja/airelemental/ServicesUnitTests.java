package ninja.airelemental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ServicesUnitTests {

    @Autowired
    private MockMvc mockMvc;

    public void shouldReturnMessageContentAndId() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello World")));
    }







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
