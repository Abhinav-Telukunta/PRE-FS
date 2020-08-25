/*Given N deck of cards and C cards in each deck and a target , the task is to select 1 card from each deck such that the sum becomes target
In how many ways can you do it?
for example if N=2,C=5 and target=10 then number of ways of getting target as 10 from 2 decks is 1 way(5+5=10) so ans=1, there is no other way to get 10
You may think 6+4=10 ,this is not possible beacuse range of variables is till 5 only(x1<=5 and x2<=5 and find how many ways such that x1+x2=10 like that)
Take another example N=3,C=7,target=14->so here task is (x1<=7 and x2<=7 and x3<=7 and find how many ways such that x1+x2+x3=14)
Find the number of ways
*/
import java.util.*;
public class dice_recursion {
	static int result=0;
	public static void possible(int[] arr,int count,int d,int ans) {
		if(d==0) {
			if(count==ans) result++;
			return;
		}
		for(int i=0;i<arr.length;++i) {
			possible(arr,count+arr[i],d-1,ans);
		}
	}
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		String[] s=sc.nextLine().split(" ");
		int d=Integer.parseInt(s[0]);
		int c=Integer.parseInt(s[1]);
		int ans=Integer.parseInt(s[2]);
		int []arr=new int[c];
		for(int i=0;i<c;++i) arr[i]=i+1;
		possible(arr,0,d,ans);
		System.out.println(result);
	}
}
