import java.util.*;
public class continuous_range{
    public static boolean isPresent(ArrayList<Integer> arr,int k){
        for(int i=0;i<arr.size();++i){
            if(arr.get(i)==k) return true;
        }
        return false;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer>arr=new ArrayList<Integer>();
        for(String s:sc.nextLine().split(" ")){
            arr.add(Integer.parseInt(s));
        }
        ArrayList<String>ans=new ArrayList<String>();
        int l=sc.nextInt();
        int r=sc.nextInt();
        int start=-1,end=-1;
        int count=0;
        for(int i=l;i<=r;++i){
            if(!isPresent(arr,i)){
                if(count==0) start=i;
                end=i;
                count=1;
            }
            else{
                if(count==1){
                    if(start<end) {
                        ans.add(start+"->"+end);
                    }
                    else ans.add(start+"");
                    count=0;
                }
            }
        }
        if(count==1){
            if(start<end) ans.add(start+"->"+end);
            else ans.add(start+"");
        }
        System.out.println(ans);
    }
}