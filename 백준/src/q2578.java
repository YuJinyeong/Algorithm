import java.util.Arrays;
import java.util.Scanner;

public class q2578 {
	
	static int board[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		board = new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		int ans = 0;
		for (int n = 1; n <= 25; n++) {
			int num = sc.nextInt();

			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (num == board[i][j]) {
						board[i][j] = 0;
						break;
					}
				}
			}

			if (n > 10 && check()) {
					ans = n;
					break;
			}
		}
		
		System.out.println(ans);
	}

	private static boolean check() {

		int cnt = 0;

		// 가로 빙고
		boolean bingo = true;
		for (int i = 0; i < 5; i++) {
			bingo = true;
			for (int j = 0; j < 5; j++) {
				if (board[i][j] != 0) {
					bingo = false;
					break;
				}
			}
			if (bingo) cnt++;
		}

		// 세로 빙고
		for (int j = 0; j < 5; j++) {
			bingo = true;
			for (int i = 0; i < 5; i++) {
				if (board[i][j] != 0) {
					bingo = false;
					break;
				}
			}
			if (bingo) cnt++;
		}

		// 좌하향 빙고
		bingo = true;
		for (int i = 0; i < 5; i++) {
			if (board[i][i] != 0) {
				bingo = false;
				break;
			}
		}
		if (bingo) cnt++;

		// 우상향 빙고
		bingo = true;
		for (int j = 0; j < 5; j++) {
			if (board[4-j][j] != 0) {
				bingo = false;
				break;
			}
		}
		if (bingo) cnt++;

		return cnt<3? false: true;
	}

}
