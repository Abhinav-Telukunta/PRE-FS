/*UGC has given permission to conduct online classes.
Now the management has scheduled the classes in N time-slots in sorted order.
i.e, time-slot[i]=(s,e) where time 't' is between s<= t <e.

All of sudden, a meeting is scheduled in time-slot P.

Now the scheduled time slot P should be removed from existing time-slots.
And return a sorted list of time-slots after such removal.


Input Format:
-------------
Line-1 -> An integer N, number of time-slots.
next N lines -> two integers s and e, indicates a time-slot
Last line -> two integers s and e, indicates time-slot of the meeting.

Output Format:
--------------
Print the list of time-slots after removal, in a sorted order.

NOTE: 
The list of time-slots after removal may be empty also.
In such case print empty list.


Sample Input-1:
---------------
3
0 2
3 4
5 7
1 6

Sample Output-1:
----------------
[[0, 1], [6, 7]]


Sample Input-2:
---------------
1
0 5
2 3

Sample Output-2:
----------------
[[0, 2], [3, 5]]
 
*/
import java.util.*;
public class overlapping_intervals{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][]arr=new int[n][2];
        for(int i=0;i<n;++i){
            for(int j=0;j<2;++j){
                arr[i][j]=sc.nextInt();
            }
        }
        int l2=sc.nextInt();
        int r2=sc.nextInt();
        ArrayList<ArrayList<Integer>>ans=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;++i){
            int l1=arr[i][0],r1=arr[i][1];
            if(!(r1<=l2 || r2<=l1)){
                int i1=Math.max(l1,l2),i2=Math.min(r1,r2);
                if(l1<i1 && i1<r1){
                    ArrayList<Integer>temp=new ArrayList<Integer>();
                    temp.add(l1);
                    temp.add(i1);
                    ans.add(temp);
                }
                if(l1<i2 && i2<r1){
                    ArrayList<Integer>temp=new ArrayList<Integer>();
                    temp.add(i2);
                    temp.add(r1);
                    ans.add(temp);
                }
                if(i1<l1 && l1<i2){
                    ArrayList<Integer>temp=new ArrayList<Integer>();
                    temp.add(i1);
                    temp.add(l1);
                    ans.add(temp);
                }
                if(i1<r1 && r1<i2){
                    ArrayList<Integer>temp=new ArrayList<Integer>();
                    temp.add(r1);
                    temp.add(i2);
                    ans.add(temp);
                }
            }
            else{
                ArrayList<Integer>temp=new ArrayList<Integer>();
                temp.add(l1);
                temp.add(r1);
                ans.add(temp);
            }
        }
        System.out.println(ans);
    }
}
