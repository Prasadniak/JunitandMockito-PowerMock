package basics;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
public class ATest {

	@Mock
	B b;
	private A a;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		a = new A(b);
	}
	
	@Test
	public void usevoidmethodshouldcallvoid() throws Exception {
		assertSame(1,a.useVoidMethod());
		verify(b).Voidmethod();
		
	}

}
