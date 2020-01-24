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

    /**
     * Section for GET endpoint calls to "/" using home()
     */

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

    /**
     * Section for GET endpoint calls to "/changes" using changes()
     */

    @Test // Happy
    public void changesReturnsChangeListInsertedByUpdate() {
        // Expect and Initialize
        Message map = Mockito.mock(Message.class);
        Principal principal = Mockito.mock(Authentication.class);
        List<Change> mockChanges = new ArrayList<>();
        mockChanges.add(new Change("admin", "This is a change from setup."));

        // Mock

        // Execute
        ChangeController realController2 = new ChangeController();
        String message = map.getContent();
        List<Change> realChanges = realController2.changes();
        realChanges.add(new Change(principal.getName(), message));
        realController2.update(map, principal);

        // Verify
        Assert.assertEquals(mockChanges.size(), realChanges.size()); // have to compare that each has 1 change

    }

    @Test // Un-Happy
    public void changesFailsToCreateOrConnect() {
        // Expect and Initialize
        Message map = Mockito.mock(Message.class);
        Principal principal = Mockito.mock(Authentication.class);
        List<Change> mockChanges = new ArrayList<>();
        mockChanges.add(new Change("admin", "This is a change from setup."));

        // Mock

        // Execute
        ChangeController realController2 = new ChangeController();
//        String message = map.getContent();
        List<Change> realChanges = realController2.changes();
//        realChanges.add(new Change(principal.getName(), message));  // Does not add any new content to the Change List.
        realController2.update(map, principal);

        // Verify
        Assert.assertNotEquals(mockChanges.size(), realChanges.size());
    }

    /**
     * Section for POST endpoint calls to "/" using update()
     */

    @Test  // Happy
    public void updateChangesTheMessageContent() {
        // Expect and Initialize
        ChangeController withChangeList = new ChangeController();
        Message map = Mockito.mock(Message.class);
        List<Change> setContent = withChangeList.changes();
        setContent.add(new Change("admin", "Hello World"));
        List<Change> content1 = withChangeList.changes();
        content1.toArray();
        content1.get(0);
        System.out.println(content1);

        // Mock


        // Execute
        setContent.add(new Change("admin", "This content is changed using update."));
        List<Change> content2 = withChangeList.changes();
        content2.toArray();
        content2.get(0);
        System.out.println(content2);

        // Verify
        Assert.assertNotEquals(content1 , content2);
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
