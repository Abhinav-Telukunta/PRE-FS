/*You will be given the matrix of size R*C,

You have to return the matrix in special order as shown in the sample tescases.
 

Input Format:
-------------
Line-1 -> Two integers R and C, size of matrix.
Next R-Lines -> C space separated integers

Output Format:
--------------
Print R-Lines -> C space separated integers, in special order.


Sample Input-1:
---------------
3 3
1 2 3
4 5 6
7 8 9

Sample Output-1:
----------------
1 2 3
6 9 8
7 4 5


Sample Input-2:
---------------
3 4
1 2 3 4
5 6 7 8
9 10 11 12

Sample Output-2:
----------------
1 2 3 4
8 12 11 10
9 5 6 7
*/
import java.util.*;
class spiral{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        int c=sc.nextInt();
        int[][]arr=new int[r][c];
        for(int i=0;i<r;++i){
            for(int j=0;j<c;++j){
                arr[i][j]=sc.nextInt();
            }
        }
        int[][]ans=new int[r][c];
        int k=0,m=r,l=0,n=c,r1=0,c1=0;
        while(k<m && l<n){
            for(int i=l;i<n;++i){
                ans[r1][c1]=arr[k][i];
                c1++;
                if(c1%c==0){
                    c1=0;
                    r1++;
                }
            }
            k++;
            for(int i=k;i<m;++i){
                ans[r1][c1]=arr[i][n-1];
                c1++;
                if(c1%c==0){
                    c1=0;
                    r1++;
                }
            }
            n--;
            if(k<m){
                for(int i=n-1;i>=l;--i){
                   ans[r1][c1]=arr[m-1][i];
                   c1++;
                   if(c1%c==0){
                       c1=0;
                       r1++;
                   }
                }
            }
            m--;
            if(l<n){
                for(int i=m-1;i>=k;--i){
                    ans[r1][c1]=arr[i][l];
                    c1++;
                    if(c1%c==0){
                        c1=0;
                        r1++;
                    }
                }
            }
            l++;
        }
        for(int i=0;i<r;++i){
            for(int j=0;j<c;++j){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
    
}
