import java.util.Scanner;

public class BJ11047 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		int[] coin = new int[n];
		int answer = 0;
		
		for (int i = 0; i < n; i++) {
			coin[i] = scan.nextInt();
		}
		
		for (int i = coin.length - 1; i >= 0; i--) {
			int tmp = (k / coin[i]);
			answer += tmp;
			k -= (tmp * coin[i]);
		}
		
		System.out.println(answer);
	}
}