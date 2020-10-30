import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Edge {
	int start;
	int end;
	int weight;
	
	public Edge(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
}

public class BJ1197 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] buffer = br.readLine().split(" ");
		int V = Integer.parseInt(buffer[0]);
		int E = Integer.parseInt(buffer[1]);
		Edge[] edges = new Edge[E];
		int[] parent = new int[V + 1];
		int answer = 0;
		
		for (int i = 0; i < E; i++) {
			buffer = br.readLine().split(" ");
			int start = Integer.parseInt(buffer[0]);
			int end = Integer.parseInt(buffer[1]);
			int weight = Integer.parseInt(buffer[2]);
			edges[i] = new Edge(start, end, weight);
		}
		
		initDisjoint(parent);
		Arrays.sort(edges, (o1, o2) -> (o1.weight - o2.weight));
		
		for (Edge edge : edges) {
			int u = edge.start;
			int v = edge.end;
			int w = edge.weight;
			
			if (!findParent(parent, u, v)) {
				unionParent(parent, u, v);
				answer += w;
			}
		}
		
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
	}
	
	public static void initDisjoint(int[] parent) {
		for (int i = 1; i < parent.length; i++) {
			parent[i] = i;
		}
	}
	
	public static void unionParent(int[] parent, int u, int v) {
		u = getParent(parent, u);
		v = getParent(parent, v);
		
		if (u < v) {
			parent[v] = u;
		} else {
			parent[u] = v;
		}
	}
	public static int getParent(int[]parent, int u) {
		if (u == parent[u]) {
			return u;
		}
		return parent[u] = getParent(parent, parent[u]);
	}
	
	public static boolean findParent(int[] parent, int u, int v) {
		u = getParent(parent, u);
		v = getParent(parent, v);
		
		if (u == v) {
			return true;
		} else {
			return false;
		}
	}
	
}