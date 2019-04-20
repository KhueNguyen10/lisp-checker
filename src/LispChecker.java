
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
		int scope = 0; // Current nested level
		char[] inputChars = input.toCharArray();
		
		// Increase current nested level for each '(' encountered, 
		// decrease for each ')'
		for (char character : inputChars) {
			if (character == '(') {
				scope++; 
			} else if (character == ')') {
				scope--;
			}
			
			// Nested level cannot be negative
			if (scope < 0) {
				return false;
			}
		}
		
		// Nested level 0 means all parentheses cancelled each other out
		if (scope == 0) {
			return true;
		} else {
			return false;
		}
	}
	
}
