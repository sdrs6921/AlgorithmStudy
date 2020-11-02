import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Edge {
	int home1;
	int home2;
	int dist;
	
	public Edge(int home1, int home2, int dist) {
		this.home1 = home1;
		this.home2 = home2;
		this.dist = dist;
	}
}

public class BJ6497 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			Edge[] edges = new Edge[n];
			int[] parent = new int[m];
			int totalDist = 0;
			int minDist = 0;
			
			if (m == 0 && n == 0) {
				break;
			}
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int home1 = Integer.parseInt(st.nextToken());
				int home2 = Integer.parseInt(st.nextToken());
				int dist = Integer.parseInt(st.nextToken());
				edges[i] = new Edge(home1, home2, dist);
				totalDist += dist; 
			}
		
		
			Arrays.sort(edges, (o1, o2) -> (o1.dist - o2.dist));
			initDisjoint(parent);
		
			for (Edge edge : edges) {
				if (!findParent(parent, edge.home1, edge.home2)) {
					minDist += edge.dist;
					unionParent(parent, edge.home1, edge.home2);
				}
			}
		
			bw.write((totalDist - minDist) + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	public static void initDisjoint(int[] parent) {
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
	}
	
	public static int getParent(int[] parent, int u) {
		if (parent[u] == u) {
			return u;
		}
		return parent[u] = getParent(parent, parent[u]);
	}
	
	public static boolean findParent(int[] parent, int u, int v) {
		u = getParent(parent, u);
		v = getParent(parent, v);
		
		if (u == v) {
			return true;
		}
		return false;
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
}