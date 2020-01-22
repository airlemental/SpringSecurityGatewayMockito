package ninja.airelemental.controllers;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AdminUserControllerTest {

  @Autowired
  private MockMvc mockMvc;


//  @GetMapping(value = "/{path:[^\\.]*}")
//  public String redirect() {
//    return "forward:/";
//  }

  // --------Happy Path would be a get call that returns the forward----------------

    @Test
    public void getPathAndTestResponseCode() throws Exception {
      // Expected, anything that calls the Admin server that isn't /user will get forward:/ returned as a string.
      String expectedReturn = "forward:/";  //How does Angular process this?
      String returnedData = new String();
      // Initialize

      // Mock
      MockHttpServletRequest request = new MockHttpServletRequest();
      // Execute
      mockMvc.perform(get("/")).andExpect(status().isOk()); //mockMvc only returns null. Why?
      // Verify   returns HTTP 302 for redirect?
      Assert.assertEquals(expectedReturn, request.getAttribute(returnedData));
    }


    //------- Non Happy Path has no return? returns 404 not found? directs incorrectly?

    @Test
    public void user() {
      //this is the same thing that William did
    }
}
