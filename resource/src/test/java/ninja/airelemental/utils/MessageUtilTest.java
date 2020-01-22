package ninja.airelemental.utils;

import ninja.airelemental.services.Change;
import ninja.airelemental.services.Message;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.security.core.Authentication;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MessageUtilTest {

    @Test
    public void transformMessage_success() {
        //Message map, Principal principal, List<Change> changes
        Message map = Mockito.mock(Message.class);
        Principal principal = Mockito.mock(Authentication.class);
        List<Change> changes = new ArrayList<>();


        Mockito.when(map.getContent()).thenReturn("This is a change message.");
        Mockito.when(principal.getName()).thenReturn("Bob");

        //Execution
        MessageUtil.transformMessage(map, principal, changes);

        // Verify
        Assert.assertEquals();

    }
}
