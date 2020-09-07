/*The N Queen is the problem of placing N chess queens on an N×N chess board,
so that no two queens attack each other. 

For example, following is a solution for 4 Queen problem.
0 1 0 0
0 0 0 1
1 0 0 0
0 0 1 0
Where, 1 indicates Queen, 0 indicates empty place.

Note: Start from leftmost column.

Input:
A single integer N, size of chess board. Where N>=4.

Output:
Print the solution as shown in sample.

Sample Input:
----------
4

Sample Output:
-----------
0 0 1 0
0 0 0 1
1 0 0 0
0 1 0 0

*/
import java.util.*;
class Nqueen{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][]board=new int[n][n];
        result(board,n,0);
    }
    public static void result(int[][]board,int n,int col){
        if(col>=n){
            for(int i=0;i<n;++i){
                for(int j=0;j<n;++j){
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
            System.exit(0);
        }
        ArrayList<Integer>valid=checkValidPositions(board,n,col);
        if(valid.size()==0) return;
        for(int i=0;i<valid.size();++i){
            board[valid.get(i)][col]=1;
            result(board,n,col+1);
            board[valid.get(i)][col]=0;
        }
        return;
    }
    public static ArrayList<Integer> checkValidPositions(int[][]board,int n,int col){
        ArrayList<Integer>valid=new ArrayList<Integer>();
        for(int row=0;row<n;++row){
            int flag=0;
            parent:for(int i=0;i<n;++i){
                for(int j=0;j<n;++j){
                    if(board[i][j]==1){
                        if(i==row || j==col || Math.abs(i-row)==Math.abs(j-col)){
                            flag=1;
                            break parent;
                        }
                    }
                }
            }
            if(flag==0) valid.add(row);
        }
        return valid;
    }
}