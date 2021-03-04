import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        String[] peopleHaveNotHeard = new String[n];
        String[] peopleHaveNotSeen = new String[m];
        List<String> peopleHaveNotHeardAndSeen = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            peopleHaveNotHeard[i] = bufferedReader.readLine();
        }

        for (int i = 0; i < m; i++) {
            peopleHaveNotSeen[i] = bufferedReader.readLine();
        }

        Arrays.sort(peopleHaveNotHeard);
        Arrays.sort(peopleHaveNotSeen);

        for (String personHasNotHeard : peopleHaveNotHeard) {
            int result = Arrays.binarySearch(peopleHaveNotSeen, personHasNotHeard);

            if (result >= 0) {
                peopleHaveNotHeardAndSeen.add(peopleHaveNotSeen[result]);
            }
        }

        bufferedWriter.write(peopleHaveNotHeardAndSeen.size() + "\n");

        for (String personHaveNotHeardAndSeen : peopleHaveNotHeardAndSeen) {
            bufferedWriter.write(personHaveNotHeardAndSeen + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

}
