import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


public class BJ1991 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] leftChild = {};
	static int[] rightChild = {};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		leftChild = new int[n];
		rightChild = new int[n];
		for (int i = 0; i < n; i++) {
			String[] buffer = br.readLine().split(" ");
			int cur = buffer[0].charAt(0) - 'A';

			if (buffer[1].equals(".")) {
				leftChild[cur] = 0;
			} else {
				leftChild[cur] = buffer[1].charAt(0) - 'A';
			}
			
			if (buffer[2].equals(".")) {
				rightChild[cur] = 0;
			} else {
				rightChild[cur] = buffer[2].charAt(0) - 'A';
			}
		}
		preOrder(0);
		bw.newLine();
		inOrder(0);
		bw.newLine();
		postOrder(0);
		bw.flush();
		bw.close();
	}
	
	public static void inOrder(int cur) throws IOException {
		if (leftChild[cur] != 0) {
			inOrder(leftChild[cur]);
		}
		bw.write((char)(cur + 'A') + "");
		if (rightChild[cur] != 0) {
			inOrder(rightChild[cur]);
		}
	}
	
	public static void preOrder(int cur) throws IOException {
		bw.write((char)(cur + 'A') + "");
		if (leftChild[cur] != 0) {
			preOrder(leftChild[cur]);
		}
		if (rightChild[cur] != 0) {
			preOrder(rightChild[cur]);
		}
	}
	
	public static void postOrder(int cur) throws IOException {
		if (leftChild[cur] != 0) {
			postOrder(leftChild[cur]);
		}
		if (rightChild[cur] != 0) {
			postOrder(rightChild[cur]);
		}
		bw.write((char)(cur + 'A') + "");
	}
	
}