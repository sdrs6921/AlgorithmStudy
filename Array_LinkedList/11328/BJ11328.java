import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BJ11328 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] answer = new int[26];
		int n = Integer.parseInt(br.readLine());
		
		for (int test = 0; test < n; test++) {
			String[] str= br.readLine().split(" ");
			Arrays.fill(answer, 0);
			
			for (int i = 0; i < str[0].length(); i++) {
				answer[str[0].charAt(i) - 'a']++;
			}
			
			for (int i = 0; i < str[1].length(); i++) {
				answer[str[1].charAt(i) - 'a']--;
			}
			
			boolean flag = true;
			
			for (int i = 0; i < 26; i++) {
				if (answer[i] != 0) {
					flag = false;
					bw.write("Impossible");
					break;
				}
			}
			
			if (flag) {
				bw.write("Possible");
			}
			bw.newLine();
			
		}
		bw.flush();
		bw.close();
	}
}