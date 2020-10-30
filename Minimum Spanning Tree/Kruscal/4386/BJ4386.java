import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Edge {
	int start;
	int end;
	double weight;
	
	public Edge(int start, int end, double weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
}

class Point {
	double x;
	double y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
}

public class BJ4386 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		boolean[] check = new boolean[n];
		int[] parent = new int[n];
		List<Edge> edges = new ArrayList<>();
		Point[] point = new Point[n];
		double answer = 0.0;
		
		for (int i = 0; i < n; i++) {
			String[] buffer = br.readLine().split(" ");
			double x = Double.parseDouble(buffer[0]);
			double y = Double.parseDouble(buffer[1]);
			
			point[i] = new Point(x, y);
		}
		
		for (int i = 0; i < point.length - 1; i++) {
			for (int j = i + 1; j < point.length; j++) {
				double dist = Math.pow(point[i].x - point[j].x, 2) + Math.pow(point[i].y - point[j].y, 2);
				dist = Math.sqrt(dist);
				edges.add(new Edge(i, j, dist));
			}
		}
		
		Collections.sort(edges, (o1, o2) -> o1.weight > o2.weight ? 1 : -1);
		
		makeDisjoint(parent);
		
		for (int i = 0; i < edges.size(); i++) {
			Edge cur = edges.get(i);
			
			if (!findParent(parent, cur.start, cur.end)) {
				answer += cur.weight;
				unionParent(parent, cur.start, cur.end);
			}
		}
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
	}
	
	public static void makeDisjoint(int[] parent) {
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
	}
	
	public static int getParent(int[] parent, int u) {
		if (parent[u] == u) {
			return u;
		} else {
			return parent[u] = getParent(parent, parent[u]);
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