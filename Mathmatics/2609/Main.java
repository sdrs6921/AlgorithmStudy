import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        bufferedWriter.write(getGCD(n, m) + "\n");
        bufferedWriter.write(getLCM(n, m) + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static int getGCD(int n, int m) {
        int min = Math.min(n ,m);
        int max = Math.max(n, m);

        if (max % min == 0) {
            return min;
        }
        return getGCD(max % min, min);
    }

    public static int getLCM (int n, int m) {
        int min = Math.min(n ,m);
        int max = Math.max(n, m);
        int LCM = max;
        for (int i = 1; i <= min; i++) {
            LCM = max * i;

            if (LCM % min == 0) {
                break;
            }
        }

        return LCM;
    }
}
