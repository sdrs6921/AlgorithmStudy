import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <=n ; i++) {
            queue.add(i);
        }

        bufferedWriter.write("<");
        while (queue.size() != 1) {
            for (int i = 0; i < k - 1; i++) {
                queue.offer(queue.poll());
            }
            bufferedWriter.write(queue.poll() + ", ");
        }
        bufferedWriter.write(queue.poll() + ">");
        bufferedWriter.newLine();


        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
