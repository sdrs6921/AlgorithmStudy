import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ10807 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] count = new int[201];
		int n = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		
		
		for (int i = 0; i < n; i++) {
			count[Integer.parseInt(s[i]) + 100]++;
		}
		
		bw.write(count[Integer.parseInt(br.readLine()) + 100] + "\n");
		
		bw.flush();
		bw.close();
	}
}