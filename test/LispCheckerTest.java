import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class LispCheckerTest {
	
	/**
	 * Return test data as input versus expected result
	 */
	public static Object[][] testData() {
		return new Object[][] {
			{"", true},
			{"()", true},
			{")(", false},
			{"(())", true},
			{"((())", false},
			{"())(", false},
			
			{ // Real LISP program from http://landoflisp.com/guess.lisp
				"(defparameter *small* 1)\r\n" + 
				"(defparameter *big* 100)\r\n" + 
				"\r\n" + 
				"(defun guess-my-number ()\r\n" + 
				"     (ash (+ *small* *big*) -1))\r\n" + 
				"\r\n" + 
				"(defun smaller ()\r\n" + 
				"     (setf *big* (1- (guess-my-number)))\r\n" + 
				"     (guess-my-number))\r\n" + 
				"\r\n" + 
				"(defun bigger ()\r\n" + 
				"     (setf *small* (1+ (guess-my-number)))\r\n" + 
				"     (guess-my-number))\r\n" + 
				"\r\n" + 
				"(defun start-over ()\r\n" + 
				"   (defparameter *small* 1)\r\n" + 
				"   (defparameter *big* 100)\r\n" + 
				"   (guess-my-number))" , true
			}
		};
	}
	
	@ParameterizedTest
	@MethodSource("testData")
	public void testCheckParentheses(String input, boolean expectedResult) {
		Assert.assertEquals(LispChecker.checkParentheses(input), expectedResult);
	}

}
