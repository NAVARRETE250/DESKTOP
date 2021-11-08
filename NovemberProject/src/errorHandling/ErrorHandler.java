package errorHandling;

public class ErrorHandler {
	
	
	public ErrorHandler(String errorMessage) {
		handleException(errorMessage);
	}
	
	public ErrorHandler(Exception e, String errorMessage) {
		handleException(e, errorMessage);
	}
	
	//Checked Exception handler
	public void handleException(Exception e, String errorMessage) {
		String className = e.getClass().getName().toString();
		
		System.out.println(className + "\n" + errorMessage);
	}
	
	//Custom Exception handler
	public void handleException(String errorMessage) {
		System.out.println(errorMessage);			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Singleton instance creation
	
	
//	private static ErrorHandler errorHandler;
//	
//	private ErrorHandler(Exception e) {
//		exception = e;
//	}
//	
//	public static ErrorHandler getHandler(Exception e) {
//		if (errorHandler == null) {
//			errorHandler = new ErrorHandler(e);		
//		}
//		showErrorMessage(e);
//		return errorHandler;
//	}	
//	
//	//Methods
//	public static String showErrorMessage(Exception e) {
//		return e.getStackTrace().toString();
//	}
//	
}
