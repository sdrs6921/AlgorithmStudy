import java.util.Arrays;
import java.util.Scanner;

public class BJ1931 {
	
	public static void main(String[] args) {
		class Meet {
			int start_time = 0;
			int end_time = 0;
		}
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Meet[] meet = new Meet[n];
		
		for (int i = 0; i < meet.length; i++) {
			meet[i] = new Meet();
			meet[i].start_time = scan.nextInt();
			meet[i].end_time = scan.nextInt();
		}
		
		Arrays.sort(meet, (o1, o2) -> (o1.end_time - o2.end_time));
		
		int answer = 0;
		int target = -1;
		
		for(int i = 0; i < meet.length; i++) {
			if (meet[i].start_time >= target) {
				answer++;
				target = meet[i].end_time;
			} 
		}
		
		System.out.println(answer);
	}
}