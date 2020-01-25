package ninja.airelemental.models;

import org.apache.commons.validator.GenericValidator;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.security.core.Authentication;

import java.security.Principal;
import java.util.Date;

public class ChangeTest {

    @Test
    public void getTimestamp() {
    // Expect and Initialize
        Message map = Mockito.mock(Message.class);
        Principal principal = Mockito.mock(Authentication.class);

     // Mock
        Mockito.when(map.getContent()).thenReturn("Hello World");
        Mockito.when(principal.getName()).thenReturn("admin");

    // Execute
        String message = map.getContent();
        Change changeInstance = (new Change(principal.getName(), message));
        Date testTime = changeInstance.getTimestamp();

    // Verify
        Assert.assertTrue(GenericValidator.isDate(String.valueOf(testTime), "EEE MMM dd HH:mm:ss zzz yyyy", true));
        // Check testTime format is correct for the date
                // formatted example
                // Fri Jan 24 11:31:23 EST 2020  , this is the return if Date() is called in Java
                // EEE MMM dd HH:mm:ss zzz yyyy
    }

    @Test
    public void getUser() {
        // Expect and Initialize
        Message map = Mockito.mock(Message.class);
        Principal principal = Mockito.mock(Authentication.class);

        // Mock
        Mockito.when(map.getContent()).thenReturn("Hello World");
        Mockito.when(principal.getName()).thenReturn("admin");

        // Execute
        String message = map.getContent();
        Change changeInstance = (new Change(principal.getName(), message));
        String userName = changeInstance.getUser();

        // Verify
        Assert.assertEquals("admin", userName);

    }

    @Test
    public void getMessage() {
        // Expect and Initialize
        Message map = Mockito.mock(Message.class);
        Principal principal = Mockito.mock(Authentication.class);

        // Mock
        Mockito.when(map.getContent()).thenReturn("Hello World");
        Mockito.when(principal.getName()).thenReturn("admin");

        // Execute
        String message = map.getContent();
        Change changeInstance = (new Change(principal.getName(), message));
        String content = changeInstance.getMessage();

        // Verify
        Assert.assertEquals("Hello World", content);
    }
}
