import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q4751_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] line = new String[3];
		String s;
		int t = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= t; tc++) {
			s = br.readLine().trim();

			if (s.length() == 1) {
				sb.append("..#..\n.#.#.\n#." + s + ".#\n.#.#.\n..#..\n");
			} else {
				line[0] = ".#..";
				line[1] = "#.#.";

				for (int i = 0; i < 2; i++) {
					sb.append(".");
					for (int j = 0; j < s.length(); j++) {
						sb.append(line[i]);
					}
					sb.append("\n");
				}
				sb.append("#");
				for (int i = 0; i < s.length(); i++) {
					sb.append("." + s.charAt(i) + ".#");
				}
				sb.append("\n");
				for (int i = 1; i >= 0; i--) {
					sb.append(".");
					for (int j = 0; j < s.length(); j++) {
						sb.append(line[i]);
					}
					sb.append("\n");
				}

			}
		}
		System.out.print(sb.toString());

	}
}
