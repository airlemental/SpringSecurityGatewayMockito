package ninja.airelemental;
//
//import ninja.airelemental.controllers.GatewayUserController;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.context.embedded.LocalServerPort;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.junit.Assert.assertEquals;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT) // acts like setting server.port property to 0, prevents collisions
public class GatewayIntegrationTests {
//
////  @Autowired      // probably not needed using TestRestTemplate, but maybe with MockMvc?
////  private GatewayUserController gatewayUserController;
//
//  @LocalServerPort  //injects HTTP port that gets allocated at Runtime.
//  private int port;
//
//
//  // http call to localhost:8080, checks authentication, session token 401 UNAUTHORIZED, serves app.component.html login section
//  private TestRestTemplate testRestTemplate = new TestRestTemplate("user", "password");
//
////  @Test
////  public void loginPageReturnsUnauthorized(){   //-----------fails------------
////    ResponseEntity<String> response = testRestTemplate.getForEntity("http://localhost:8080/", String.class);
////    assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
////  }
//
//  @Test
//  public void loginPageReturnsUnauthorized(){  //----------fails--------------
//    // does not work because HttpStatus is ok because login page is returned, what checks authorization token?
//    ResponseEntity<String> response = testRestTemplate.getForEntity("http://localhost:" + port + "/", String.class);
//    assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
//  }
//
//  // http call to localhost:8080, checks authentication, session token 200 OK, serves app.component.html with 1 or 2 buttons based on ROLE
//  private TestRestTemplate testRestUserTemplate = new TestRestTemplate("user", "password");
//
////  @Test
////  public void loginPageReturnsUserOK(){  ------fails----------
////    ResponseEntity<GatewayUserController> response = testRestUserTemplate.getForEntity("http://localhost:8080/user", GatewayUserController.class);
////    assertEquals(HttpStatus.OK, response.getStatusCode());
////  }
//
//  @Test
//  public void loginPageReturnsUserOK(){  // ----success------  why is random port working but not specified port?
//    ResponseEntity<String> response = testRestUserTemplate.getForEntity("http://localhost:" + port + "/user", String.class);
//    assertEquals(HttpStatus.OK, response.getStatusCode());
//  }
//
//
//
//  private TestRestTemplate testRestAdminTemplate = new TestRestTemplate("admin", "admin");
//
//  @Test
//  public void loginPageReturnsAdminOK(){
//    ResponseEntity<GatewayUserController> response = testRestAdminTemplate.getForEntity("http://localhost:8080/user", GatewayUserController.class);
//    assertEquals(HttpStatus.OK, response.getStatusCode());
//  }
//
//  // page submit button used from login page, one or both fields blank, returns 401 UNAUTHORIZED
//
//  // page submit button used, Username and Password checked against "GatewaySecurityConfig",
//  //         if Role User found, only displays Go To UI button
//  //         if Role Admin found, displays UI and Admin buttons
//
//  // UI button clicked, returns status 200, serves /ui page, contains new resource generated UUID and content from UI.
//
//  // clicking Home always returns login page.
//
//  // clicking logout invalidates session token and returns basic login screen
//
//
}
//
//
//
