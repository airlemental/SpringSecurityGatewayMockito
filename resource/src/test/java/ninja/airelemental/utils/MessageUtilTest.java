package ninja.airelemental.utils;

import ninja.airelemental.models.Change;
import ninja.airelemental.models.Message;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.security.core.Authentication;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

public class MessageUtilTest {

    @Test
    public void adminSubmitsNewChange_success() throws Exception {
        //Message map, Principal principal, List<Change> changes
        Message map = Mockito.mock(Message.class);
        Principal principal = Mockito.mock(Authentication.class);
        List<Change> changes = new ArrayList<>();

        //Mock
        Mockito.when(map.getContent()).thenReturn("This is a change message.");
        Mockito.when(principal.getName()).thenReturn("Bob");

        //Execution
        String newChange = MessageUtil.adminSubmitsNewChange(map, principal, changes);

        //Verify
        Assert.assertEquals("This is a change message.", newChange);

    }

    @Test
    public void changeListLimitOfTen_Success() throws Exception {
        //Message map, Principal principal, List<Change> changes
        Message map = Mockito.mock(Message.class);
        Principal principal = Mockito.mock(Authentication.class);
        List<Change> changes = new ArrayList<>();

        //Mock
        Mockito.when(map.getContent()).thenReturn("This is a change message.");
        Mockito.when(principal.getName()).thenReturn("Bob");

        //Execution
        String newChange = MessageUtil.adminSubmitsNewChange(map, principal, changes);
        int sizeOfList01 = changes.size();
//        System.out.println(sizeOfList01);
        for(int i = 1; i < 100; i++){
            MessageUtil.adminSubmitsNewChange(map, principal, changes);
        }
        int sizeOfList02 = changes.size();
//        System.out.println(sizeOfList02);
        Assert.assertTrue(sizeOfList02 <= 10);


        //Verify
        Assert.assertEquals("This is a change message.", newChange);

    }

}
























