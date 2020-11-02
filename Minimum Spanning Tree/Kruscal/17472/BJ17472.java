import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Edge {
	int island1;
	int island2;
	int dist;
	
	public Edge(int island1, int island2, int dist) {
		this.island1 = island1;
		this.island2 = island2;
		this.dist = dist;
	}
}

public class BJ17472 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		int[][] map = new int[n][m];
		boolean[][] visited = new boolean[n][m];
		int count = 0;
		Queue<Point> q = new LinkedList<>();
		ArrayList<Edge> edges = new ArrayList<>();
		int[] parent;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					q.offer(new Point(i, j));
					visited[i][j] = true;
					map[i][j] = ++count;
					
					while (!q.isEmpty()) {
						Point cur = q.poll();
						
						for (int k = 0; k < 4; k++) {
							int x = cur.x + dx[k];
							int y = cur.y + dy[k];
							
							if (x < 0 || y < 0 || x >=n || y >= m) {
								continue;
							} else if (map[x][y] != 1 || visited[x][y]) {
								continue;
							}
							q.offer(new Point(x, y));
							visited[x][y] = true;
							map[x][y] = count;
						}
					}
					
				}
			}
		}
		
		for (int land = 1; land <= count; land++) {
			int[][] dist = new int[n][m];
			boolean[] check = new boolean[count + 1];
			
			for (int i = 0; i < n; i++) {
				Arrays.fill(dist[i], -1);
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == land) {
						q.offer(new Point(i, j));
						dist[i][j] = 0;
					}
				}
			}
			
			while (!q.isEmpty()) {
				Point cur = q.poll();
				
				for (int i = 0; i < 4; i++) {
					int x = cur.x + dx[i];
					int y = cur.y;
					if (x < 0 || x >= n) {
						continue;
					} else if(dist[x][y] >= 0) {
						continue;
					} else if (map[x][y] != 0 && map[x][y] != land) {
						if (dist[cur.x][cur.y] != 1 && !check[map[x][y]]) {
							edges.add(new Edge(land, map[x][y], dist[cur.x][cur.y]));
							check[map[x][y]] = true;
						}
						continue;
					}
					q.offer(new Point(x, y));
					dist[x][y] = dist[cur.x][cur.y] + 1;
				}
			}
			check = new boolean[count + 1];
			
			for (int i = 0; i < n; i++) {
				Arrays.fill(dist[i], -1);
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == land) {
						q.offer(new Point(i, j));
						dist[i][j] = 0;
					}
				}
			}
			
			while (!q.isEmpty()) {
				Point cur = q.poll();
				
				for (int i = 0; i < 4; i++) {
					int x = cur.x;
					int y = cur.y + dy[i];
					if (y < 0 || y >= m) {
						continue;
					} else if(dist[x][y] >= 0) {
						continue;
					} else if (map[x][y] != 0 && map[x][y] != land) {
						if (dist[cur.x][cur.y] != 1 && !check[map[x][y]]) {
							edges.add(new Edge(land, map[x][y], dist[cur.x][cur.y]));
							check[map[x][y]] = true;
						}
						continue;
					}
					q.offer(new Point(x, y));
					dist[x][y] = dist[cur.x][cur.y] + 1;
				}
			}
		}
		
		parent = new int[count + 1];
		int answer = 0;
		boolean flag = true;
		initDisjoint(parent);
		
		Collections.sort(edges, (o1, o2) -> (o1.dist - o2.dist));
		
		for (Edge edge : edges) {
			if (!findParent(parent, edge.island1, edge.island2)) {
				answer += edge.dist;
				unionParent(parent, edge.island1, edge.island2);
			}
		}
		
		for (int i = 1; i < parent.length; i++) {
			if (getParent(parent, i) != 1) {
				bw.write("-1\n");
				flag = false;
				break;
			}
		}
		
		if (flag) {
			bw.write(answer +"\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	public static void initDisjoint(int[] parent) {
		for (int i = 1; i < parent.length; i++) {
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