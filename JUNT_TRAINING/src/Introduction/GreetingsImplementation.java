package Introduction;

public class GreetingsImplementation implements Greetings {

	@Override
	public String greet(String name) {
		
		if( name==null || name.length()==0 )
		{
			throw new IllegalArgumentException();
		}
		return "Hello "+name;
	}

}
