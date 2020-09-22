/*There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. 
 The cost of painting each house with a certain color is different. 
 You have to paint all the houses such that no two adjacent houses have the same color. 
 The cost of painting each house with a certain color is represented by a n x 3 cost matrix. 
 For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on.
 print minimum cost required to paint all villas
 dp-2
 */
import java.util.*;
public class paint_villas {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[][]cost=new int[n][3];
		for(int i=0;i<n;++i) {
			for(int j=0;j<3;++j) {
				cost[i][j]=sc.nextInt();
			}
		}
		int[][]dp=new int[n][3];
		dp[0][0]=cost[0][0];
		dp[0][1]=cost[0][1];
		dp[0][2]=cost[0][2];
		int col1=0,col2=0;
		for(int i=1;i<n;++i) {
			for(int j=0;j<3;++j) {
				if(j==0) {
					col1=1;
					col2=2;
				}
				else if(j==1) {
					col1=0;
					col2=2;
				}
				else {
					col1=0;
					col2=1;
				}
				dp[i][j]=Math.min(dp[i-1][col1],dp[i-1][col2])+cost[i][j];
			}
		}
		int minn=Integer.MAX_VALUE;
		for(int i=0;i<3;++i) {
			if(dp[n-1][i]<minn) minn=dp[n-1][i];
		}
		System.out.println(minn);
	}
}
