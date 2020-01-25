package ninja.airelemental.config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
public class ResourceSecurityConfigTest {

    @Test  // -------------------for configure---------------------
    public void ifSomeoneTriesToPost_DetermineTheyAreWriter() {

        // Initialization
        String expectedName = "Arnold";
        String expectedRole = "ROLE_WRITER";

        // Mocking Part
        Principal user = Mockito.mock(Authentication.class);
        Authentication userAuthenticated = (Authentication)user;
//        MockUserController mockUserController = Mockito.mock(MockUserController.class);
        MockUserController mockUserController = new MockUserController();

        Mockito.when(userAuthenticated.getName()).thenReturn(expectedName);
        Mockito.when(userAuthenticated.getAuthorities()).thenAnswer(invocationOnMock -> {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_WRITER");
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            grantedAuthorities.add(grantedAuthority);
            return grantedAuthorities;
        });

        // Execution Part
        Map<String, Object> stringObjectMap = mockUserController.determineUserRole(user);

        // Verify expecting outcome
        Assert.assertEquals(expectedName, stringObjectMap.get("name"));
        Assert.assertEquals("[" + expectedRole + "]", stringObjectMap.get("roles").toString());
    }

//    private ResourceSecurityConfig resourceSecurityConfig = new ResourceSecurityConfig();
//    private final InMemoryTraceRepository repository = new InMemoryTraceRepository();
//    private TraceProperties properties = new TraceProperties();
//    private WebRequestTraceFilter filter = new WebRequestTraceFilter(this.repository, this.properties);


    //------------------------For WebRequestTraceFilter------------------------

//    @Autowired
//    @Qualifier("springSecurityFilterChain")
//    private Filter springSecurityFilterChain;
//
//    public void getFilters() {
//        FilterChainProxy filterChainProxy = (FilterChainProxy) springSecurityFilterChain;
//        List<SecurityFilterChain> list = filterChainProxy.getFilterChains();
//        list.stream()
//                .flatMap(chain -> chain.getFilters().stream())
//                .forEach(filter -> System.out.println(filter.getClass()));
//    }
//
//    @Test
//    public void verifyDefaultFilterOrderChanged() {
////        MockHttpServletRequest request = new MockHttpServletRequest("GET", "/user");
//        ResourceSecurityConfigTest resourceSecurityConfigTest = new ResourceSecurityConfigTest();
//        resourceSecurityConfigTest.getFilters();
//    }

}






















