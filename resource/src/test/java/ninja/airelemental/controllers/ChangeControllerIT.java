package ninja.airelemental.controllers;

import ninja.airelemental.services.Change;
import ninja.airelemental.services.Message;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;
import java.util.UUID;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ChangeController.class)
@Ignore
public class ChangeControllerIT {

    @Autowired
    private MockMvc mockMvc;

    private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

    @MockBean
    ChangeController changeController;

    @MockBean
    Message message;

    @MockBean
    Change change;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new ChangeController()).build();

        // populate changes list with pre-made "Change" instances

//        changeController.update({content: this.greeting['content']}, "admin");

//        mockMvc.perform(put("/resource").contentType(CONTENT_TYPE).content("{'this.greeting':'This is message One'},{'principal','admin'}"));
//        mockMvc.perform(put("/resource").contentType(CONTENT_TYPE).content("{'this.greeting':'This is message Two'},{'principal','admin'}"));
//        mockMvc.perform(put("/resource").contentType(CONTENT_TYPE).content("{'this.greeting':'This is message Three'},{'principal','admin'}"));
//        mockMvc.perform(put("/resource").contentType(CONTENT_TYPE).content("{'this.greeting':'This is message Four'},{'principal','admin'}"));
    }

    @After
    public void tearDown() throws Exception {

        // Needs to remove all update() data

    }

    @Test // simply pulls the root content from ChangeController variable, starts as "Hello World"
    @WithMockUser
    public void homeReturnsMessage() throws Exception {
        // Expected
        String expectedMessage = "Hello World";
        String id = UUID.randomUUID().toString(); // how to match it since calling it generates a new one each time? Just make sure it's not blank?
        String expectedUser = "admin";
        Date expectedTimestamp = new Date();
        // Initialize
        Message message = Mockito.mock(Message.class);
        Change change = Mockito.mock(Change.class);
        // Mock
        Mockito.when(change.getMessage()).thenReturn(expectedMessage);
        Mockito.when(change.getUser()).thenReturn(expectedUser);
        Mockito.when(change.getTimestamp()).thenReturn(expectedTimestamp);
        // Execute
        mockMvc.perform(get("/").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(print())
//                .andExpect(jsonPath("$[0]", is(expectedTimestamp)))
                .andExpect(jsonPath("$[1]", is(expectedUser)))
                .andExpect(jsonPath("$[2]", is(expectedMessage)));

        // Verify




    }

    // {{item.timestamp}} ({{item.user}}): "{{item.message}}"
    // from write.component.ts
    // this.http.post('/resource', {content: this.greeting['content']})
    @Test // this pulls the list of admin changes from the stored List<>
    @WithMockUser
    public void changes() throws Exception {
//        List<Change> changes = Arrays.asList(
//                new Change("admin", "This is message One"),
//                new Change("admin", "This is message Two"),
//                new Change("admin", "This is message Three"),
//                new Change("admin", "This is message Four")
//        );


        // -----I think the update() method needs to populate the Change list before it tries to pull a list, or it needs it's own setup.
        mockMvc.perform(get("/changes"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[0].user", is("admin")))
                .andExpect(jsonPath("$[0].message", is("This is message One")));



    }

    @Test // this submit the filled text box and changes the displayed content and stores the changes in the array
    @WithMockUser
    public void update() throws Exception {
        mockMvc.perform(post("/resource").contentType(MediaType.APPLICATION_JSON).content("{'message.content':'Because changes are coming'}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$[0].user", is("admin")))
                .andExpect(jsonPath("$[0].message", is("Because changes are coming")));

    }  // ---------------fails with "expected 201, received 404"
       // --------------How do I determine what the correct way to pass JSON messages as if the web page was calling the update method natively?
}
