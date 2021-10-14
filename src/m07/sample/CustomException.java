package m07.sample;

@SuppressWarnings("serial")
public class CustomException extends Exception{

	//overriding the toString method of Exception
	public String toString()
	{
		return "This is my Custom Exception";
	}
}
