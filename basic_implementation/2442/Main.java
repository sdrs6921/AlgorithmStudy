import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (2 * n - 1); j++) {
                if (j < n-i-1) {
                    bufferedWriter.write(" ");
                } else if (j > n+i-1) {
                    break;
                } else {
                    bufferedWriter.write("*");
                }
            }
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

}
