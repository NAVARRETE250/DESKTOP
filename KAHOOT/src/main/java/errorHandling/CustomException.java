package main.java.errorHandling;

public class CustomException extends Exception{
	//Custom Exception Class for handling Exceptions we design
	private String messageToShow;
	
	public CustomException(String errorMessage) {
		//Calls error handler
		setMessageToShow(new ErrorHandler().handleException(errorMessage));
	}
	
	public String getMessageToShow() {
		return messageToShow;
	}
	
	public void setMessageToShow(String messageToShow) {
		this.messageToShow = messageToShow;
	}
}