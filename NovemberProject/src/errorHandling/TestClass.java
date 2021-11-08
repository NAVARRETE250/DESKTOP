package errorHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestClass {
	public static void main(String[] args) {
		TestClass tc = new TestClass();
		tc.testMethod();
		//Test to check if execution of the program hasn't stopped before this point
		System.out.println("Goodbye");
		
	}
		
		public TestClass() {
		}
		
		public void testMethod() {
			boolean testing = true; 
			Scanner sc = new Scanner(System.in);
			int x;
			int y ;
			while (testing) {
				try {
					System.out.println("Input a number");
					x = sc.nextInt();
					
					y = x / 5;
					if (x == 0) {
						testing = false;
						sc.close();
						break; 
						}
					if (x == 25) {
						throw new CustomException("random condition 1");
					}
					
					if (y == 1) {
						throw new CustomException("random condition 2");
					}
					
					String[] list = {"pony"};
					
					System.out.println("Choose element from list");
					
					//For testing out of bounds exception
					System.out.println(list[sc.nextInt()]);
					
					//Triggers ArithmeticException
					y = 5 / 0;
					
				} catch (CustomException e) {   //This catches any custom exception we design
					
				// We add the checked exceptions that might come out at the end
				} catch (ArrayIndexOutOfBoundsException e) {
					new ErrorHandler(e, e.getMessage());
				} catch (ArithmeticException e) {
					new ErrorHandler(e, e.getMessage());
				} catch (InputMismatchException e) {
					new ErrorHandler(e, "Please, enter only integers");
					//Have to initialize this again because this error causes the scanner to stop
					sc = new Scanner(System.in); 
				}
				//Still executes after throwing Exception
				System.out.println("All okay");	
				
			}
			
		}
		
		//Custom Exception Class for handling Exceptions we design
		class CustomException extends Exception {
			public CustomException(String errorMessage) {
				//Calls error handler
				new ErrorHandler(errorMessage);
			}
		} 
}
