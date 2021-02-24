import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q2579 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] steps = new int[N+1][2];
		for(int n=1; n<=N; n++) {
			steps[n][0] = Integer.parseInt(in.readLine());
		}

		steps[N][1] = steps[N][0];
		for(int i=N; i>=1; i--) {
			if(steps[N][1] == 0) continue;
			if(i == 1)
				steps[i-1][1] = Math.max(steps[0][1], steps[i][1]);
			else if(i == 2)
				steps[i-2][1] = Math.max(steps[0][1], steps[i][1] + steps[i-1][0]);
			else {
			//앞으로 두 칸 가기
			if(i>=2)
				steps[i-2][1] = Math.max(steps[i-2][1], steps[i][1] + steps[i-2][0]);
			
			//앞으로 한 칸 갔다가 다시 두 칸 가기
			if(i>=3)
				steps[i-3][1] = Math.max(steps[i-3][1], steps[i][1] + steps[i-1][0] +  + steps[i-3][0]);
		
			}
		}
		
		System.out.println(steps[0][1]);
	}
}
