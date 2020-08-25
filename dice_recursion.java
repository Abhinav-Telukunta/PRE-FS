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
