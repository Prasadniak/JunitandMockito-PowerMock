package SimpleAddition;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class AddingImplementationTest {

	private int num1;
	private int num2;
	private int exresult;

	public AddingImplementationTest(int num1, int num2, int result) {
		this.num1 = num1;
		this.num2 = num2;
		this.exresult = result;
	}

	@Parameters
	public static Collection<Integer[]> data(){
		return Arrays.asList(new Integer[][]{{2,2,4},{-8,10,2}});
	}
	@Test
	public void Adding_theNumbers() {
		Addition ad = new AddingImplementation();
		int add = ad.add(num1, num2);
		assertEquals(exresult, add);
	}

}


/*
 *       The steps required to do when we need to use Parameterized JUnit
 *       
 *        1)Identify The Input Data And Result
 * 		  2)Create Fields in Test Class
 * 		  3)Create a Constructor
 * 		  4)Create a Static Method         @Parameter
 * 		  5)Create or UPdate the Test Method          And mark class with @RunWith(Parameterized.class)
 * 
 *                  @@@@@ PowerMock @@@@
 *  				PowerMock allows to mock static , final , Constructors , Private , enum which mockito doesnt provide
 * 					It does ByteCode Manipulation and CustomClass Loader
 *  * 
 * */
 