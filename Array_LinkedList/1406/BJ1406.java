import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BJ1406 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> lstack = new Stack<>();
		Stack<Character> rstack = new Stack<>();
		String text = br.readLine();
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < text.length(); i++) {
			lstack.add(text.charAt(i));
		}
		
		for (int i = 0; i < n; i++) {
			String[] command = br.readLine().split(" ");
			
			switch (command[0]) {
				case "L":
					if (!lstack.isEmpty()) {
						rstack.add(lstack.pop());
					}
					break;
				case "D":
					if (!rstack.isEmpty()) {
						lstack.add(rstack.pop());
					}
					break;
				case "B":
					if (!lstack.isEmpty()) {
						lstack.pop();
					}
					break;
				case "P":
					lstack.push(command[1].charAt(0));
					break;
					
			}
		}
		
		StringBuilder answer = new StringBuilder();
		
		while (!lstack.isEmpty()) {
			rstack.push(lstack.pop());
		}
		
		while (!rstack.isEmpty()) {
			answer.append(rstack.pop());
		}
		
		bw.write(answer.toString());
		bw.newLine();
		bw.flush();
		bw.close();
	}
}