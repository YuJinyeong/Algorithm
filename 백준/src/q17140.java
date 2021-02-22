import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.List;

//Q.17140 이차원 배열과 연산
public class q17140 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int r = Integer.parseInt(st.nextToken())-1;
		int c = Integer.parseInt(st.nextToken())-1;
		int k = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[100][100];
		int R = 3, C = 0, NR = 0, NC = 0;
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int j = 0;
			while(st.hasMoreTokens()) {
				map[i][j++] = Integer.parseInt(st.nextToken());
			}
			C = Math.max(C, j);
		}
		
		int answer = 0;
		while(true) {
			if(map[r][c] == k) break;
			answer++;
			//100초가 지나도 되지 않으면 종료
			if(answer >= 100)  {
				answer = -1;
				break;
			}
//			System.out.println("R: " + R + ", C: " + C);
			Map<Integer, Integer> hm;
			if(R >= C) { //R 연산
				NC = 0;
//				System.out.println(answer + " R연산");
				for(int i=0; i<R; i++) {
					hm = new HashMap<>();
					for(int j=0; j<C; j++) {
						if(map[i][j] == 0) continue;
						if(hm.containsKey(map[i][j])) 
							hm.put(map[i][j], hm.get(map[i][j])+1);
						else
							hm.put(map[i][j], 1);
					}

					List<Entry<Integer, Integer>> list = new ArrayList<>(hm.entrySet());
					Collections.sort(list, new Comparator<Entry<Integer, Integer>>() {
						@Override
						public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
							if(o2.getValue() == o1.getValue())
								return o1.getKey() - o2.getKey();
							return o1.getValue().compareTo(o2.getValue());
						}
					});
					
					NC = Math.max(NC, hm.size()*2);
					
					int j = 0;
					for(Entry<Integer, Integer> entry : list) {
						map[i][j] = entry.getKey();
						map[i][j+1] = entry.getValue();
						j+=2;
						if(j >= 100) break;
					}
					while(j<100 && j<C) {
						map[i][j] = 0;
						j++;
						if(j>=100) break;
					}
				}
				C = NC;
			}else { //C 연산
				NR = 0;
//				System.out.println(answer + " C연산");
				for(int j=0; j<C; j++) {
					hm = new HashMap<>();
					for(int i=0; i<R; i++) {
						if(map[i][j] == 0) continue;
						if(hm.containsKey(map[i][j])) 
							hm.put(map[i][j], hm.get(map[i][j])+1);
						else
							hm.put(map[i][j], 1);
					}

					List<Entry<Integer, Integer>> list = new ArrayList<>(hm.entrySet());
					Collections.sort(list, new Comparator<Entry<Integer, Integer>>() {
						@Override
						public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
							if(o2.getValue() == o1.getValue())
								return o1.getKey() - o2.getKey();
							return o1.getValue().compareTo(o2.getValue());
						}
					});
					
					NR = Math.max(NR, hm.size()*2);
					
					int i=0;
					for(Entry<Integer, Integer> entry : list) {
						map[i][j] = entry.getKey();
						map[i+1][j] = entry.getValue();
						i+=2;
						if(i >= 100) break;
					}
					while(i<100 && i<R) {
						map[i][j] = 0;
						i++;
						if(i>=100) break;
					}
				}
				R = NR;
			}
//			//결과 인쇄
//			for(int i=0; i<R; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			
		}
		
		System.out.println(answer);
	}
}
