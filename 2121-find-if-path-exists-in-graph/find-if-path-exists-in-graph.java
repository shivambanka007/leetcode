class Solution {
    private static int[] parent;
	static void init(int n){
		parent=new int[n];
		for(int i=0;i<n;i++){
			parent[i]=i;
		}
	}
	static int find(int n){
		if(parent[n]==n)return n;
		return find(parent[n]);
	}
	static void union(int x,int y){
			int px=find(x);
			int py=find(y);
			if(px==py){return;}
			parent[py] = px;
	}
public static boolean validPath(int n, int[][] edges, int source, int destination) {
	if(source==destination)return true;
	if(edges==null)return false;
	if(edges.length==0)return false;
	init(n);
	for(int[] edge:edges){
		//System.out.println("Edges"+edge[0]+","+edge[1]);
		union(edge[0],edge[1]);
	}
	// System.out.println(Arrays.toString(parent));
	// System.out.println("Parent of Source:"+find(source));
	// System.out.println("Parent of Destination:"+find(destination));
	return find(source)==find(destination); 
    }
}