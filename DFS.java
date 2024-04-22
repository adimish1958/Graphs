package Graph;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS {
	
	private int V;
	private LinkedList<Integer> adj[];
	public DFS(int v){
		V=v;
		adj=new LinkedList[v];
		for(int i=0;i<v;i++) {
			adj[i]=new LinkedList<Integer>();
	}
	}
	void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	void DFSUtil(int v) {
		
		boolean visited[]=new boolean[V];
		DFSImpl(v,visited);
	}
		
		

	void DFSImpl(int v, boolean[] visited) {
		// TODO Auto-generated method stub
		visited[v]=true;
		System.out.print(v + " ");
		Iterator i=adj[v].listIterator();
		while(i.hasNext()) {
			int n=(int) i.next();
			if(!visited[n]) {
				DFSImpl(n,visited);
			}
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DFS g=new DFS(4);
		 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println(
            "Following is Depth First Traversal "
            + "(starting from vertex 2)");
 
        // Function call
        g.DFSUtil(2);
    }

}
