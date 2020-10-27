import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Tree {
	int value;
	int level;
	int xIndex;
	Tree parent;
	Tree leftChild;
	Tree rightChild;
	
	public Tree(int value) {
		this.value = value;
		this.leftChild = null;
		this.rightChild = null;
		this.parent = null;
	}
}

public class BJ2250 {
	static int xIndex = 1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int maxTreeLevel = (int) (Math.ceil(Math.log(n) / Math.log(2)) + 1);
		int[] treeWidth = new int[maxTreeLevel];
		Tree[] tree = new Tree[n + 1];
		int rootIdx = -1;
		
		for (int i = 1; i <= n; i++) {
			tree[i] = new Tree(i);
		}
		
		for (int i = 1; i <= n; i++) {
			String[] buffer = br.readLine().split(" ");
			int root = Integer.parseInt(buffer[0]);
			int left = Integer.parseInt(buffer[1]);
			int right = Integer.parseInt(buffer[2]);
			
			if (left > 0) {
				tree[root].leftChild = tree[left];
				tree[left].parent = tree[root];
			}
			
			if (right > 0) {
				tree[root].rightChild = tree[right];
				tree[right].parent = tree[root];
			}
		}
		
		for (int i = 1; i <= n; i++) {
			if (tree[i].parent == null) {
				rootIdx = i;
			}
		}
		
		inOrder(tree[rootIdx], 1);
		
		
		
		for (int i = 0; i < treeWidth.length; i++) {
			int max = -1;
			int min = n+1;
			
			for (int j = 1; j <= n; j++) {
				if (tree[j].level == i + 1) {
					if (tree[j].xIndex > max) {
						max = tree[j].xIndex;
					}
					if (tree[j].xIndex < min) {
						min = tree[j].xIndex;
					}
				}
			}
			
			treeWidth[i] = (max - min) + 1;
		}
		
		int max_idx = 0, max = -1;
		
		for (int i = 0; i < treeWidth.length; i++) {
			if (max < treeWidth[i]) {
				max = treeWidth[i];
				max_idx = i + 1;
			}
		}
		
		bw.write(max_idx + " " + max + "\n");
		bw.flush();
		bw.close();
	}
	
	public static void inOrder(Tree root, int level) {
		if (root.leftChild != null) {
			inOrder(root.leftChild, level+1);
		}
		root.xIndex = xIndex++;
		root.level = level;
		if (root.rightChild != null) {
			inOrder(root.rightChild, level+1);
		}
	}
}