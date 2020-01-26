package ninja.airelemental.models;

import org.apache.commons.validator.GenericValidator;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.data.crossstore.ChangeSetPersister;

public class MessageTest {

    @Test
    public void getId() throws Exception {  // UUID is generated new every time, just validate not null and correct format.
        // Expect and Initialize
        Message message = new Message();

        // Mock

        // Execute
        String newId = message.getId();

        // Verify
        if(newId.isEmpty()){
            throw new ChangeSetPersister.NotFoundException();
        } else {
            Assert.assertTrue(GenericValidator.matchRegexp(newId, "[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}"));
        }
//        Assert.assertNotNull(newId);
//        Assert.assertTrue(GenericValidator.matchRegexp(newId, "[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}"));

    }

    @Test
    public void getContent() throws Exception {

        // Expect and Initialize
        Message message = new Message("Test Content for Message");

        // Mock

        // Execute
        String id = message.getId();
        String newContent = message.getContent();
        System.out.println(id);
        System.out.println(newContent);

        // Verify
        Assert.assertNotNull(id);
        Assert.assertNotNull(newContent);
        Assert.assertEquals(newContent, "Test Content for Message");

    }

//    @GetMapping("/user")
//    @ResponseBody
//    public Map<String, Object> user(Principal user) {
//        Map<String, Object> map = new LinkedHashMap<>();
//        map.put("name", user.getName());
//        map.put("roles", AuthorityUtils.authorityListToSet(((Authentication) user).getAuthorities()));
//        return map;
//    }
}
