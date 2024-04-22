package Graph;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS {
	private int V;
	private LinkedList<Integer> adj[];
	public BFS(int v){
		V=v;
		adj=new LinkedList[v];
		for(int i=0;i<v;i++) {
			adj[i]=new LinkedList<Integer>();
	}
	}
	void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	void BFSUtil(int v) {
		boolean visited[]=new boolean[V];
		LinkedList<Integer>q=new LinkedList<Integer>();
		q.offer(v);
		visited[v]=true;
		while(!q.isEmpty()) {
			int n=q.poll();
			
			System.out.print(n + " ");
			Iterator i=adj[n].listIterator();
			while(i.hasNext()) {
				int s=(int) i.next();
				if(!visited[s]) {
					visited[s]=true;
					q.offer(s);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BFS g=new BFS(4);
		 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println(
            "Following is Breadth First Traversal "
            + "(starting from vertex 2)");
 
        // Function call
        g.BFSUtil(0);

	}

}
