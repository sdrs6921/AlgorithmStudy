import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BJ9012 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		Stack<Character> s = new Stack<>();
		
		for (int test = 0; test < testCase; test++) {
			String str = br.readLine();
			
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(') {
					s.push('(');
				} else {
					if (s.isEmpty()) {
						s.push(')');
						break;
					} else {
						s.pop();
					}
				}
			}
			
			if (s.isEmpty()) {
				bw.write("YES");
			} else {
				bw.write("NO");
			}
			bw.newLine();
			s.clear();
		}
		
		bw.flush();
		bw.close();
	}
}