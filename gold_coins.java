/*Bharath won a lucky draw to grab the gold coins at Lalitha Jewellery Store.
Store manager has placed N boxes of gold coins in a row, 
each box has some gold coins in it.

Bharath is allowed to pick any number of boxes, with a condition.
The condition is, he is not allowed to pick the adjacent boxes.

You will be given a list of integers indicates number of gold coins in each box.
Your task is to find out the maximum number of gold coins can bharath earn.

Input Format:
-------------
Line-1: An integer N, number of boxes.
Line-2: N space separated integers, gold coins in each box.

Output Format:
--------------
Print an integer, maximum number of gold coins.


Sample Input-1:
---------------
4
1 2 3 1

Sample Output-1:
----------------
4

Explanation:
------------
Pick Box 1 (gold coins = 1) and then Pick Box 3 (gold coins = 3).
Total gold coins you can earn = 1 + 3 = 4.

Sample Input-2:
---------------
5
2 7 9 3 1

Sample Output-2:
----------------
12

Explanation:
------------
Pick Box-1 (gold coins = 2), Pick Box-3 (gold coins = 9) and then Pick Box-5 (gold coins = 1).
Total gold coins you can earn = 2 + 9 + 1 = 12.
*/
import java.util.*;
class gold{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;++i) arr[i]=sc.nextInt();
        int[] memo=new int[n];
        Arrays.fill(memo,-1);
        int ans=compute(arr,memo,n-1);
        System.out.println(ans);
    }
    public static int compute(int[] arr,int[] memo,int i){
        if(i<0) return 0;
        if(memo[i]>=0) return memo[i];
        int res=Math.max(arr[i]+compute(arr,memo,i-2),compute(arr,memo,i-1));
        memo[i]=res;
        return res;
    }
}
