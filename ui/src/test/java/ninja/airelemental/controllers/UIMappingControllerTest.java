package ninja.airelemental.controllers;

import org.junit.Test;

public class UIMappingControllerTest {

    @Test  // Happy
    public void rootEndpointReturnsForwardString() {
      // Expect and Initialize
      String expectedReturn = "forward:/";

      // Mock


      // Execute

      // Verify
    }

  @Test  // Un-Happy
  public void rootEndpointHasIncorrectOrNoValue() {
    // Expect and Initialize
    String expectedReturn = "forward:/";

    // Mock


    // Execute

    // Verify
  }

    @Test  // Happy
    public void userEndpointReturnsMapOfUsers() {
      // Expect and Initialize

      // Mock


      // Execute

      // Verify
    }

  @Test  // Un-Happy
  public void userEndpointFailsOrDoesNotReturnMap() {
    // Expect and Initialize

    // Mock


    // Execute

    // Verify
  }

}
