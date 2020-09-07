/*
Given an undirected graph of N nodes and  m colors, 
determine if the graph can be coloured with at most m colours 
such that no two adjacent vertices of the graph are colored with the same color. 
colors are numbered from 1 to M.
Here coloring of a graph means the assignment of colors to all vertices.

Input Format:
-----------
Line-1 -> Two integers N and M, N vertices and M colors
Next N lines -> N space separated integers (0,1) only.

Output Format:
-----------
Print True if it is possible
If not possible, Print False

Sample Input:
-------------
4 3
0 1 1 1
1 0 1 0
1 1 0 1
1 0 1 0

Sample Output:
------------
True


Sample Input:
-------------
4 3
1 1 1 1
1 1 1 1
1 1 1 1
1 1 1 1

Sample Output:
-------------
False
*/
import java.util.*;
class coloring{
    static int V;
    static int[] colors;
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        V=sc.nextInt();
        int m=sc.nextInt();
        int[][]graph=new int[V][V];
        for(int i=0;i<V;++i){
            for(int j=0;j<V;++j){
                graph[i][j]=sc.nextInt();
            }
        }
        colors=new int[V];
        if(graphColoring(graph,colors,m,0)){
            System.out.println("True");
        }
        else System.out.println("False");
    }
    public static boolean graphColoring(int[][]graph,int[] colors,int m,int v){
        if(v==V) return true;
        for(int c=1;c<=m;++c){
            if(isSafe(graph,colors,v,c)){
                colors[v]=c;
                if(graphColoring(graph,colors,m,v+1)) return true;
                colors[v]=0;
            }
        }
        return false;
    }
    public static boolean isSafe(int[][]graph,int[]colors,int v,int c){
        for(int i=0;i<V;++i){
            if(graph[v][i]==1 && c==colors[i]) return false;
        }
        return true;
    }
}