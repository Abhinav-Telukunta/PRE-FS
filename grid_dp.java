/*You have given flatland in the form of m*n grid,
The land contains some ponds represented as 0,
and the land represented as 1.

Your task is to find the number of square-grids which contains no pond. 


Input Format:
-------------
Line-1: Two integers M and N.
Next M lines: N space separated integers.

Output Format:
--------------
Print an integer, number of square-grids.


Sample Input-1:
---------------
3 4
0 1 1 1
1 1 1 1
0 1 1 1

Sample Output-1:
----------------
15

Explanation:
------------
There are 10 square-grids of side length 1.
There are 4 square-grids of side length 2.
There is 1 square-grid of side length 3.

Total number of square-grids without a pond in it = 10 + 4 + 1 = 15.


Sample Input-2:
---------------
3 3
1 0 1
1 1 0
1 1 0

Sample Output-2:
----------------
7

Explanation:
------------
There are 6 square-grids of side length 1.
There is 1 square-grid of side length 2.
Total number of square-grids without a pond in it = 6 + 1 = 7.
*/
import java.util.*;
public class grid_dp {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int row=sc.nextInt();
		int col=sc.nextInt();
		int[][]arr=new int[row][col];
		for(int i=0;i<row;++i) {
			for(int j=0;j<col;++j) {
				arr[i][j]=sc.nextInt();
			}
		}
		int[][]dp=new int[row][col];
		for(int i=0;i<row;++i) {
			for(int j=0;j<col;++j) {
				dp[i][j]=arr[i][j];
			}
		}
		for(int i=0;i<row;++i) {
			for(int j=0;j<col;++j) {
				if(dp[i][j]>=1) {
					int up=Integer.MAX_VALUE,left=Integer.MAX_VALUE,left_up=Integer.MAX_VALUE;
					if(i-1>=0) up=dp[i-1][j];
					if(j-1>=0) left=dp[i][j-1];
					if(i-1>=0 && j-1>=0) left_up=dp[i-1][j-1];
					if(up!=Integer.MAX_VALUE && left!=Integer.MAX_VALUE && left_up!=Integer.MAX_VALUE) {
						dp[i][j]=Math.min(up,Math.min(left,left_up))+1;
					}

				}
			}
		}
		int ans=0;
		for(int i=0;i<row;++i) {
			for(int j=0;j<col;++j) {
				ans+=dp[i][j];
			}
		}
		System.out.println(ans);
	}
}
