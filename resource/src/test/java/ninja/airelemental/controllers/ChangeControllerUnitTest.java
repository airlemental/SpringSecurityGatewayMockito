package ninja.airelemental.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    /**   ------------------- section 1 ---------------------
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
        String message = "This is a change from setup."; // This simply changes the message that is expected without changing the class's variable.

        // Mock
        ChangeController changeController = Mockito.mock(ChangeController.class);
        Mockito.when(changeController.home()).thenReturn(new Message(message));

        // Execute
        ChangeController realController = new ChangeController();
        Message newMessage = realController.home();

        // Verify
        Assert.assertNotEquals(message, newMessage.getContent());
    }

    /**    ----------------- section 2 ------------------------------
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

    /**         --------------- section 3 ---------------------------
     * Section for POST endpoint calls to "/" using update()
     */

    @Test  // Happy
    public void updateChangesTheMessageContent() throws JsonProcessingException {
        // Expect and Initialize
        ObjectMapper mapTheChanges = new ObjectMapper();


        // Mock
        ChangeController withChangeList = new ChangeController();
        List<Change> setContent = withChangeList.changes();

        // Execute
        setContent.add(new Change("Pooh", "Hello World"));
        List<Change> firstSave = setContent;
        String content1 = mapTheChanges.writeValueAsString(firstSave);
        System.out.println(content1);

        setContent.add(new Change("Piglet", "Our Content Options have Changed"));
        List<Change> secondSave = setContent;
        String content2 = mapTheChanges.writeValueAsString(secondSave);
        System.out.println(content2);

        // Verify
        Assert.assertSame(firstSave, secondSave);
        Assert.assertNotSame(content1.length(), content2.length());

    }

    @Test  // Un-Happy
    public void updateDoesNotChangeTheMessageContent()  {
        // Expect and Initialize

/** How do I write a meaningful "the change did not update" test?
 *
 */


        // Mock


        // Execute


        // Verify

    }


}
