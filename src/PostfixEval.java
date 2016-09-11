import java.util.Scanner;
import java.util.Stack;


public class PostfixEval {

	public static void main(String[] args) {
		Scanner getInput = new Scanner(System.in);
		System.out.print("Enter your postfix equation: ");
		String input = getInput.nextLine();
		evaluation(input);
	}
	
	static void evaluation(String eqn) {
		Stack<Integer> stack = new Stack<Integer>();
		int x1, x2;
		char op;
		
		for (int i = 0; i < eqn.length(); i++) {
			if (eqn.charAt(i) >= '0' && eqn.charAt(i) <= '9') {
				stack.push(Character.getNumericValue(eqn.charAt(i)));
			} else if (eqn.charAt(i) >= '*' && eqn.charAt(i) <= '/') {
				x1 = stack.pop();
				x2 = stack.pop();
				op = eqn.charAt(i);
				switch (op) {
				case '+':
					stack.push(x2 + x1);
					break;
				case '-':
					stack.push(x2 - x1);
					break;
				case '*':
					stack.push(x2 * x1);
					break;
				case '/':
					stack.push(x2 / x1);
					break;
				default:
					System.err.println("Error! no valid operator");
					break;
				}
			}
		}
		printStack(stack);
	}
	static void printStack(Stack<Integer> s) {
		if (s.isEmpty()) {
			System.out.println("You've nothing in your stack!");
		} else {
			System.out.printf("Evaluation is %s \n", s);
		}
	}
	
}
