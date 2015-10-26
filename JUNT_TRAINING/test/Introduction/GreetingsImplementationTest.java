package Introduction;

import static org.junit.Assert.*;

import javax.xml.ws.Action;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GreetingsImplementationTest {
	
	private Greetings g;

	@Before
	public void setup()
	{
		g = new GreetingsImplementation();		
	}

	@Test
	public void testGreetingImplementation() {
		String gname = g.greet("Prasad");
		assertNotNull(gname);
		assertEquals("Hello Prasad",gname);
	}
	
	@Test(expected = IllegalArgumentException.class)
	 public void testGreetingsImplementation_ForNull()
	 {
		g.greet(null);
	 }
	
	@Test(expected = IllegalArgumentException.class)
	 public void testGreetingsImplementation_ForEmpty()
	{
		g.greet("");
	}
	
	@After
	public void teardown()
	{
		g = null;
	}
	
	

}
