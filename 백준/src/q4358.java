import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

//Q.4358 생태학
public class q4358 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		int total = 0;
		Map<String, Integer> map = new TreeMap<>();
		while((str = in.readLine()) != null && str.length() != 0) {
//			System.out.println(str.length());
			total++;
			if(map.get(str) != null) {
				map.put(str, map.get(str)+1);
			}else
				map.put(str, 1);
		}
		
		for(String key : map.keySet()) {
			double value = (double)(map.get(key)*100) / (double)total;
			System.out.println(key + " " + String.format("%.4f", value));
		}
	}
}
