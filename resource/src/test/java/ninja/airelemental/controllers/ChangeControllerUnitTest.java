package ninja.airelemental.controllers;

import ninja.airelemental.models.Change;
import ninja.airelemental.models.Message;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.security.core.Authentication;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

public class ChangeControllerUnitTest {

    @Test // Happy
    public void homeReturnsBasicMessage() {
        // Expect and Initialize
        String message = "Hello World";

        // Mock
        ChangeController changeController = Mockito.mock(ChangeController.class);
        Mockito.when(changeController.home()).thenReturn(new Message(message));

        // Execute
        ChangeController realController = new ChangeController();
        Message newMessage = realController.home();

        // Verify
        Assert.assertEquals(message, newMessage.getContent());

    }

    @Test // Un-Happy
    public void homeReturnsNothingOrWrongMessage() {
        // Expect and Initialize
        String message = "This is a change from setup.";

        // Mock
        ChangeController changeController = Mockito.mock(ChangeController.class);
        Mockito.when(changeController.home()).thenReturn(new Message(message));

        // Execute
        ChangeController realController = new ChangeController();
        Message newMessage = realController.home();

        // Verify
        Assert.assertNotEquals(message, newMessage.getContent());
    }

    @Test // Happy
    public void changesReturnsAListOfChanges() {
        // Expect and Initialize
        String originalMessage = "Hello World";
        List<Change> changes = new ArrayList<>();
        changes.add(new Change("admin", "This is a change from setup."));

        // Mock
        ChangeController changeController = Mockito.mock(ChangeController.class);

        // Execute
        ChangeController realController2 = new ChangeController();
//        realController2.changes("'user': 'admin'", "'content':'This is a change from the real Class.'");

        // Verify
//        Assert.assertEquals(changes, List from actual controller); // have to compare that each has 1 change

    }

    @Test // Un-Happy
    public void changesFailsToCreateOrConnect() {
        // Expect and Initialize

        // Mock
        ChangeController changeController = Mockito.mock(ChangeController.class);

        // Execute

        // Verify
    }

    @Test  // Happy
    public void updateChangesTheMessageContent() {
        // Expect and Initialize
        String expectedMessage = "This is a change message.";
        Message map = Mockito.mock(Message.class);
        Principal principal = Mockito.mock(Authentication.class);

        // Mock
        ChangeController changeController = Mockito.mock(ChangeController.class);
        Mockito.when(map.getContent()).thenReturn("This is a change message.");
        Mockito.when(principal.getName()).thenReturn("Bob");

        // Execute
        ChangeController realController4 = new ChangeController();
        Message newChange = realController4.update(map, principal);

        // Verify
        Assert.assertEquals(expectedMessage, newChange.getContent());
    }

    @Test  // Happy
    public void updateDoesNotChangeTheMessageContent() {
        // Expect and Initialize

        // Mock
        ChangeController changeController = Mockito.mock(ChangeController.class);

        // Execute

        // Verify
    }

}
