//package ninja.airelemental.config;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import java.security.Principal;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
////@ContextConfiguration
////@WebAppConfiguration
//@SpringBootTest
//public class ResourceSecurityConfigTest {
//
//    @Autowired
//    private WebApplicationContext context;
//    private MockMvc mockMvc;
//
//    @Before  // must integrate the security filter chain in MockMvc object
//    public void setup() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
//    }
//
//    ResourceSecurityConfig resourceSecurityConfig = new ResourceSecurityConfig();
//
//
//    @Test
//    @WithMockUser(roles = "WRITER")
//    public void authenticateOnlyIfCredentialsHaveWriter() throws Exception {
//        // Initialization
//        String expectedName = "admin";
//        String expectedRole = "ROLE_WRITER";
//        Principal user = Mockito.mock(Authentication.class);
//        Authentication userAuthenticated =  (Authentication)user;
//
//        // Mocking Part
//        Mockito.when(userAuthenticated.getName()).thenReturn(expectedName);
//        Mockito.when(userAuthenticated.getAuthorities()).thenAnswer(invocationOnMock -> {
//            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(expectedRole);
//            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//            grantedAuthorities.add(grantedAuthority);
//            return grantedAuthorities;
//        });

        // Execution Part

//        mockMvc.perform(MockMvcRequestBuilders.post("/")
//                .accept(MediaType.ALL))
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("WRITER")));

//        Map<String, Object> stringObjectMap = resourceSecurityConfig.configure();

        // Verify expecting outcome

//    }


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

//}






















