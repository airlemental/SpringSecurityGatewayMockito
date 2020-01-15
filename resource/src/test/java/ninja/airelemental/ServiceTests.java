package ninja.airelemental;

import ninja.airelemental.services.Message;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class ServiceTests {

    @ActiveProfiles("test")
    @RunWith(SpringJUnit4ClassRunner.class)
    @SpringBootTest(classes = ResourceApplication.class)  // replaces @SpringApplicationConfiguration
    public class MessageServiceUnitTest {

        @Autowired
        private Message message;

        @Test
        public void whenIdIsCalledReturnUUID() {
            String testUUID = message.getId();
            Assert.assertNotNull(testUUID);
        }

    }



}
