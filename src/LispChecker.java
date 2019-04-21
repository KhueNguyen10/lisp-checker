import java.util.EmptyStackException;
import java.util.Stack;

public class LispChecker {
	
	public static void main(String[] args) {
		String input = args[0];
		boolean result = checkParentheses(input);
		System.out.println(result);
	}
	
	/**
	 * Check if the given input's parentheses are properly closed and nested.
	 */
	public static boolean checkParentheses(String input) {
		char[] inputChars = input.toCharArray();
		Stack<Character> parenStack = new Stack<>();
		
		// Push every '(' and pop every ')'
		for (char character : inputChars) {
			if (character == '(') {
				parenStack.push(character);
			} else if (character == ')') {
				try {
					parenStack.pop();
				} catch (EmptyStackException ex) {
					// This exception happens when a ')' comes before a '('
					// Fail immediately
					return false;
				}
			}
		}
		
		// Empty stack means there was a ')' for every '('
		return parenStack.empty();
	}
	
}
