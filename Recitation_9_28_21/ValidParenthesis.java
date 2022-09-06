package Recitation_9_28_21;

import java.util.*;

public class ValidParenthesis {
	public static void main(String[] args) {
		System.out.println("IsValid [()]{}[]: \t" + isValidParenthesesGroup("[()]{}[]"));
		System.out.println("IsValid [)]{}[]: \t" + isValidParenthesesGroup("[)]{}[]"));
		System.out.println("IsValid [[]: \t\t" + isValidParenthesesGroup("[[]"));
		System.out.println("IsValid ): \t\t" + isValidParenthesesGroup(")"));
	}

	public static boolean isValidParenthesesGroup(String parenthesesText) {
		Stack<Character> parenthesesStack = new Stack<>();
		for (int i = 0; i < parenthesesText.length(); i++) {
			switch (parenthesesText.charAt(i)) {
				case '(':
				case '[':
				case '{':
					parenthesesStack.push(parenthesesText.charAt(i));	
					break;
				case ')':
					if (parenthesesStack.isEmpty() || parenthesesStack.pop() != '(')
						return false;
					break;
				case '}':
					if (parenthesesStack.isEmpty() || parenthesesStack.pop() != '{')
						return false;
					break;
				case ']':
					if (parenthesesStack.isEmpty() || parenthesesStack.pop() != '[')
						return false;
					break;
			}
		}
		return parenthesesStack.isEmpty();
	}
}