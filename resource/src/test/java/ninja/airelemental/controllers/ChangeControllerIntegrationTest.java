package ninja.airelemental.controllers;

import ninja.airelemental.models.Change;
import ninja.airelemental.models.Message;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;
import java.util.List;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ChangeControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

    @Test
    public void homeEndpointRootReturnsMessage() throws Exception {
        // Expect and Initialize
        String expectedMessage = "Hello World";
        ChangeController changeController = Mockito.mock(ChangeController.class);

        // Mock
        Message message = Mockito.mock(Message.class);
        Mockito.when(changeController.home()).thenReturn(new Message(expectedMessage));

        // Execute
        mockMvc.perform(get("/").contentType(CONTENT_TYPE))
                .andExpect(status().isOk());

        // Verify
//        verify(message.getContent("Hello World"));
    }

    @Test // call /changes with 2 parameters, message and user, and it creates a new instance of Change and adds to the List<Change>
    public void changesEndpointCreatesNewChangeObject() throws Exception {
        // Expect and Initialize
        String expectedChange = "This Message Has Been Changed";
        String expectedUser = "admin";
        ChangeController changeController = Mockito.mock(ChangeController.class);
        List<Change> changes = new ArrayList<>();

        // Mock
        Mockito.when(changeController.changes()).thenReturn(changes);

        // Execute
        mockMvc.perform(get("/changes"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect((ResultMatcher) jsonPath("$[0].user", is(expectedUser)))
                .andExpect((ResultMatcher) jsonPath("$[0].message", is(expectedChange)));

        // Verify
    }

    @Test
    public void updateChangesTheMessageContent() throws Exception {
        // Expect and Initialize

        // Mock

        // Execute

        // Verify
    }
}
