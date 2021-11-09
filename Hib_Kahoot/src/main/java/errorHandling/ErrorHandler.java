package errorHandling;

import javax.swing.JOptionPane;

public class ErrorHandler {
	
	
	public ErrorHandler() {
	}

	
	//Checked Exception handler
	public String handleException(Exception e, String errorMessage) {
		String className = e.getClass().getName().toString();
		
		return className + "\n" + errorMessage;
	}
	
	//Custom Exception handler
	public String handleException(String errorMessage) {
		return errorMessage;			
	}
	
}