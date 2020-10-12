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
		Stack<Integer> s = new Stack<>();
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			String[] command = br.readLine().split(" ");
			
			switch (command[0]) {
				case "push":
					s.push(Integer.parseInt(command[1]));
					break;
				case "pop":
					if (s.isEmpty()) {
						bw.write("-1" + "\n");
					} else {
						bw.write(s.pop() + "\n");
					}
					break;
				case "empty":
					if (s.isEmpty()) {
						bw.write("1" + "\n");
					} else {
						bw.write("0" + "\n");
					}
					break;
				case "top":
					if (s.isEmpty()) {
						bw.write("-1" + "\n");
					} else {
						bw.write(s.peek() + "\n");
					}
					break;
				case "size":
					bw.write(s.size() + "\n");
					break;
			}
		}
		bw.flush();
		bw.close();
	}
}