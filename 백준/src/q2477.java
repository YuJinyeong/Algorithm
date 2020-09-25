import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2477 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int K = Integer.parseInt(in.readLine());
		int large1=0, large2=0, start=0, h_idx=0, w_idx=0;
		int map[][] = new int[6][2];
		for(int i=0; i<6; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
			
			// 큰 사각형의 세로 길이
			if(map[i][0]<3 && map[i][1]>large1)	{
				large1 = map[i][1];
				h_idx = i;
			}
			// 큰 사각형의 가로 길이
			else if(map[i][0]>2 && map[i][1]>large2)	{
				large2 = map[i][1];
				w_idx = i;
			}
		}
		
		// 큰 사각형의 가로, 세로 길이 중 나중에 입력받은 거 인덱스 구하기
		if((h_idx==0 && w_idx==5)||(w_idx==0 && h_idx==5)) {
			start = 0;
		}else {
			start = Math.max(h_idx, w_idx);
		}
		
		// 작은 사각형의 가로, 세로 길이
		int min1 = map[(start + 2)%6][1];
		int min2 = map[(start + 3)%6][1];
		
//		System.out.println("H:" + large1 + " W:" + large2 + " h:" + min2 + " w:" + min1);
		System.out.println(K*(large1*large2-min2*min1)); // (큰 사각형의 넓이 - 작은 사각형의 넓이) * 일정 면적당 참외의 개수
		
	}

}
