package errorHandling;

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
