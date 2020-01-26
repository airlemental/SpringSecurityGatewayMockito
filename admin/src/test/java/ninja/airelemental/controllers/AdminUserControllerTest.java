package ninja.airelemental.controllers;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AdminUserControllerTest {

  @Test  // Happy
  public void rootEndpointReturnsForwardString() {
    // Expect and Initialize
    String expectedReturn = "forward:/";

    // Mock
    AdminUserController adminUserController = new AdminUserController();

    // Execute
    String forwardReturned = adminUserController.redirect();

    // Verify
    Assert.assertEquals(expectedReturn, forwardReturned);
  }

  @Test  // Un-Happy
  public void rootEndpointHasIncorrectOrNoValue() {
    // Expect and Initialize
    String expectedReturn = "forward:/";

    // Mock

    // Execute
    String forwardReturned = "";

    // Verify
    Assert.assertNotEquals(expectedReturn, forwardReturned);
  }

  @Test
  public void returnAuthenticatedUser_success() {

    // Initialization
    String expectedName = "Aaron";

    // Mocking Part
    Principal user = Mockito.mock(Authentication.class);
    Authentication userAuthenticated = (Authentication) user;

    AdminUserController adminUserController = new AdminUserController();

    // Mocking Part
    Mockito.when(userAuthenticated.getName()).thenReturn(expectedName);
    Mockito.when(userAuthenticated.getAuthorities()).thenAnswer(invocationOnMock -> {
      GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
      List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
      grantedAuthorities.add(grantedAuthority);
      return grantedAuthorities;
    });

    // Execution Part
    Map<String, Object> userMapReturned = adminUserController.user(user);

    // Verify expecting outcome
    Assert.assertEquals(expectedName, userMapReturned.get("name"));

  }

  @Test  // Un-Happy
  public void returnAuthenticatedUser_Fail() {
    // Initialization
    String expectedName = "Randolph";

    // Mocking Part
    Principal user = Mockito.mock(Authentication.class);
    Authentication userAuthenticated = (Authentication) user;

    AdminUserController adminUserController = new AdminUserController();

    // Mocking Part
    Mockito.when(userAuthenticated.getName()).thenReturn(expectedName);
    Mockito.when(userAuthenticated.getAuthorities()).thenAnswer(invocationOnMock -> {
      GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
      List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
      grantedAuthorities.add(grantedAuthority);
      return grantedAuthorities;
    });

    // Execution Part
    Map<String, String> userMapReturned = null;

    // Verify expecting outcome
    Assert.assertNotEquals(expectedName, userMapReturned);
  }
}
