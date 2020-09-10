package study_0909;

public class 문자열압축 {
	public static void main(String[] args) {
		System.out.println(solution("a"));
	}

	static int solution(String s) {
		int ans = Integer.MAX_VALUE;
		int cnt = 0, len = 0;

		System.out.println(s.length());
		String cur="", nxt="", res="";
		int j = 0;
		for (int i = 1; i < (s.length() + 0.5) / 2; i++) {
			cur = s.substring(0, i);
			cnt = 1;
			res = cur;

			for (j = i; j <= s.length() - i; j += i) {
				if (j == s.length() - i)
					nxt = s.substring(j);
				else
					nxt = s.substring(j, i + j);
				
				if (cur.equals(nxt))
					cnt++;
				else {
					if(cnt > 1) res += cnt;
					res += nxt;
					cur = nxt;
					cnt = 1;
				}
			}
			if(cnt > 1) res += cnt;
			res += s.substring(j);

			System.out.println(i + "일 때 : " + res + "(" + res.length() + ")");
			if(ans > res.length())	ans = res.length();
		}

		if(ans == Integer.MAX_VALUE)	ans = 1;
		return ans;
	}

}
