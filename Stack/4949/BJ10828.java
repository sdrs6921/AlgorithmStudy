import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BJ10828 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack s = new Stack();
		String input = br.readLine();
		
		while (!input.equals(".")) {
			for (int i = 0; i < input.length(); i++) {
				char tmp = input.charAt(i);
				
				if (tmp == '(' || tmp == '[') {
					s.push(tmp);
				} else if (tmp == ')' || tmp == ']') {
					if (s.isEmpty() || ((char)s.peek() == '[' && tmp == ')') || ((char)s.peek() == '(' && tmp ==']')) {
						s.push(tmp);
						break;
					} else {
						s.pop();
					}
				} 
			}
			
			if (s.isEmpty()) {
				bw.write("yes");
			} else {
				bw.write("no");
			}
			bw.newLine();
			input = br.readLine();
			s.clear();
		}
		
		bw.flush();
		bw.close();
	}
}