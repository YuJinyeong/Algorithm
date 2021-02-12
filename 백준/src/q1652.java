import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Q.1652 누울 자리를 찾아라
public class q1652 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		char[][] map = new char[N][];
		for (int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
		}

		int jari;
		// 가로로 누울 수 있는지
		int h = 0;
		for (int i = 0; i < N; i++) {
			jari = 0;
			for (int j = 0; j < N; j++) {
				if (map[i][j] == '.')
					jari++;
				if (map[i][j] == 'X' || j == N - 1) { // 벽을 만났을 때
					if (jari > 1) h++;
					jari = 0;
				}
			}
		}
		
		int v=0;
		// 세로로 누울 수 있는지
		for (int j = 0; j < N; j++) {
			jari = 0;
			for (int i = 0; i < N; i++) {
				if (map[i][j] == '.')
					jari++;
				if (map[i][j] != '.' || i == N - 1) { // 벽을 만났을 때
					if (jari > 1) v++;
					jari = 0;
				}
			}
		}
		
		System.out.println(h + " " + v);
	}
}
