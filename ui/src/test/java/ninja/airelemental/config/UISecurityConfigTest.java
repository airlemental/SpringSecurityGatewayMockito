package ninja.airelemental.config;

import ninja.airelemental.controllers.UIMappingController;
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

public class UISecurityConfigTest {

  @Test
  public void determineUserRole_success() {

    // This is an @Override configuration of the WebSecurityConfigurerAdapter. Need to figure out what part gets tested.

    // Initialization
    String expectedName = "Peasants";

    // Mocking Part
    Principal user = Mockito.mock(Authentication.class);
    Authentication userAuthenticated = (Authentication) user;

    UIMappingController uiMappingController = new UIMappingController();

    // Mocking Part
    Mockito.when(userAuthenticated.getName()).thenReturn(expectedName);
    Mockito.when(userAuthenticated.getAuthorities()).thenAnswer(invocationOnMock -> {
      GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
      List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
      grantedAuthorities.add(grantedAuthority);
      return grantedAuthorities;
    });

    // Execution Part
    Map<String, String> stringObjectMap = uiMappingController.user(user);

    // Verify expecting outcome
    Assert.assertEquals(expectedName, stringObjectMap.get("name"));


  }
}
