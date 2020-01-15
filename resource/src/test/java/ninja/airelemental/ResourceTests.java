package ninja.airelemental;

import ninja.airelemental.controllers.ChangeController;
import ninja.airelemental.services.Change;
import ninja.airelemental.services.Message;
import org.junit.Test;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.security.Principal;

import static org.junit.Assert.assertEquals;


public class ResourceTests {
	
	private ChangeController resource = new ChangeController();

	@Test
	public void home() {
		assertEquals("Hello World", resource.home().getContent());
	}

	@Test
	public void changes() {
		Principal user = new UsernamePasswordAuthenticationToken("admin", "");
		resource.update(new Message("Foo"), user);
		assertEquals(1, resource.changes().size());
	}

	@Test
	public void changesOverflow() {
		for (int i=1; i<=11; i++) { resource.changes().add(new Change("foo", "bar")); }
		Principal user = new UsernamePasswordAuthenticationToken("admin", "");
		resource.update(new Message("Foo"), user);
		assertEquals(10, resource.changes().size());
	}

}
