/*
given an array arr which is initially sorted.
It is rotated anticlockwise for some elements 
A key is given to search in array using binary search
example-arr-7 1 2 3 4 5 6
key-5
so answer is index of 5 in array which is=5
if key is not present print -1
*/
import java.util.*;
class search{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;++i) arr[i]=sc.nextInt();
        int key=sc.nextInt();
        int low=0,high=n-1,pivot=0;
        while(low<=high){
            pivot=(low+high)/2;
            if(pivot+1<n && arr[pivot]>arr[pivot+1]){
                break;
            }
            else if(arr[pivot]<arr[0]) high=pivot-1;
            else low=pivot+1;
        }
        int ridx=(pivot+1)%n;
        //System.out.println(ridx);
        int mid=0;
        int right=(ridx-1);
        if(right<0) right=n-1;
        if(key<arr[ridx] || (key>arr[right])){
            System.out.println(-1);
            System.exit(0);
        }
        low=0;
        high=n-1;
        int flag=0;
        if(key>arr[high]) high=ridx-1;
        else if(key<arr[high]) low=ridx;
        while(low<=high){
            mid=(low+high)/2;
            if(key==arr[mid]){
                System.out.println(mid);
                flag=1;
                break;
            }
            else if(key>arr[mid]) low=mid+1;
            else if(key<arr[mid]) high=mid-1;
        }
        if(flag==0) System.out.println(-1);
        

    }
}
