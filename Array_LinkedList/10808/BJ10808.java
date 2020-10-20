import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BJ10808 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] count = new int[26];
		String str = br.readLine();
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			count[ch - 'a']++;
		}
		
		for (int i = 0; i < count.length; i++) {
			bw.write(count[i] + " ");
		}
		bw.newLine();
		
		bw.flush();
		bw.close();
	}
}