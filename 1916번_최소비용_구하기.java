import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Node>[] graph;
	
	public static int Dijkstra(int n, int start, int end) {
		boolean[] check = new boolean[n + 1];
		int[] dist = new int[n+1];
		int INF = Integer.MAX_VALUE;
		
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			int nowVertex = pq.poll().index;
			
			if(check[nowVertex]) continue;
			check[nowVertex] = true;
			
			//index의 연결된 정점 비교
			for(Node next : graph[nowVertex]) {
				if(dist[next.index] > dist[nowVertex]+ next.cost) {
					dist[next.index] = dist[nowVertex] + next.cost;
					
					pq.offer(new Node(next.index, dist[next.index]));
				}
			}
		}
		return dist[end];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		int m = Integer.parseInt(bf.readLine());
		
		graph = new ArrayList[n+1];
		for (int i = 0; i <= n; i++)  graph[i] = new ArrayList<>();
		
		StringTokenizer st;
		for(int i = 0 ; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph[v].add(new Node(w, cost));
		}
		
		st = new StringTokenizer(bf.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		System.out.println(Dijkstra(n, start, end));
		
	}
}

class Node implements Comparable<Node>{
	int index;
	int cost;
	
	public Node(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.cost, o.cost);
		/*
		 Integer.compare(int x, int y)
		 x == y ->  0 return 
		 x < y  ->  -1 return 
		 x > y  ->  1 return 
		 */
	}
}
