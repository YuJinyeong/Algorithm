package study_0909;

public class 괄호변환 {
	public static void main(String[] args) {
		System.out.println(solution(")("));
	}

	static String solution(String p) {
		String answer = "";

		answer = divUV(p);

		return answer;
	}

	static String divUV(String p) {
		String u = "", v = "";
		
		System.out.println("divUV: " + p);
		if(p == "") return p;

		boolean right = true;
		int opn = 0, cls = 0, idx = 0;
		for (; idx < p.length(); idx++) {
			if (p.charAt(idx) == '(')
				opn++;
			else
				cls++;

			if (opn < cls)
				right = false;
			else if (opn == cls)
				break;
		}
		
		if (idx >= p.length()-1) {
			u = p;
			v = "";
		} else {
			u = p.substring(0, idx + 1);
			v = p.substring(idx + 1);
		}
//		System.out.println("u: " + u + ", v: " + v);

		if (right)
			return u + divUV(v);
		else
			return change(u, v);
	}

	private static String change(String u, String v) {
		System.out.println("change: " + u + ", " + v);
		String r = "";
		for (int i = 1; i < u.length() - 1; i++) {
			if (u.charAt(i) == '(')
				r += ")";
			else
				r += "(";
		}
		return "(" + divUV(v) + ")" + r;
	}

}
