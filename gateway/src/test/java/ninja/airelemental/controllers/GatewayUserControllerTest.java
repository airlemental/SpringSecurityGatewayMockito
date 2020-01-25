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

public class GatewayUserControllerTest {

  private GatewayUserController gatewayUserController = new GatewayUserController();

  /***  -----Williams Example--------------
   * Happy Path for the method
   */
  @Test
  public void determineUserRole_success() {
    String expectedName = "Marcus";
    String expectedRole = "ROLE_USER, ROLE_ADMIN";
    // Initialization
    Principal user = Mockito.mock(Authentication.class);
    Authentication userAuthenticated =  (Authentication)user;

    // Mocking Part
    Mockito.when(userAuthenticated.getName()).thenReturn(expectedName);
    Mockito.when(userAuthenticated.getAuthorities()).thenAnswer(invocationOnMock -> {
      GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
      GrantedAuthority grantedAuthorityTwo = new SimpleGrantedAuthority("ROLE_ADMIN");
      List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
      grantedAuthorities.add(grantedAuthority);
      grantedAuthorities.add(grantedAuthorityTwo);
      return grantedAuthorities;
    });

    // Execution Part
    Map<String, Object>  stringObjectMap = gatewayUserController.determineUserRole(user);

    // Verify expecting outcome
    Assert.assertEquals(expectedName, stringObjectMap.get("name"));
    Assert.assertEquals("["+expectedRole+"]", stringObjectMap.get("roles").toString());
  }

  /**
   * Unhappy Path for the method    -----Williams Example--------------
   */
  @Test(expected = ClassCastException.class)
  public void determineUserRole_cannotGetUserRole() {
    // Initialization
    Principal user = new Principal() {
      @Override
      public String getName() {
        return null;
      }
    };

    gatewayUserController.determineUserRole(user);
    // Assert there some kind of failure
  }
}
