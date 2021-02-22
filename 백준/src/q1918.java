import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//Q.1918 후위 표기식
public class q1918 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		Stack<Character> stack = new Stack<>();
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= 'A' && c <= 'Z')
				result += c;
			else if (c == '(')
				stack.push(c);
			else if (c == ')') {
				while (!stack.isEmpty()) {
					char nxt = stack.pop();
					if (nxt == '(')
						break;
					result += nxt;
				}
			} else {
				while(!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(c)) {
					result += stack.pop();
				}
				stack.push(c);
			}
		}
		while(!stack.isEmpty())
			result += stack.pop();
		
		System.out.println(result);
	}

	public static int getPriority(char c) {
		if (c == '(')
			return 0;
		else if (c == '+' || c == '-')
			return 1;
		else
			return 2;
	}
}
