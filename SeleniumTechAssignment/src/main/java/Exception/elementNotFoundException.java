package Exception;

import java.io.IOException;

import Utils.TakeScreenShot;

public class elementNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	public elementNotFoundException(String message) throws IOException{
		super(message);
    } 
}
