import java.util.*;
public class min_distance{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in).useDelimiter("\n");
        String[] s=sc.next().split(" ");
        String[] w=sc.next().split(" ");
        String w1=w[0],w2=w[1];
        int f=-1,e=-1;
        if(w1.equals(w2)){
            int minn=Integer.MAX_VALUE;
            for(int i=0;i<s.length;++i){
                if(s[i].equals(w1) && f==-1) f=i;
                else if(s[i].equals(w2) && f!=-1){
                    e=i;
                    minn=Math.min(minn,Math.abs(f-e));
                    f=i;
                }
            }
            System.out.println(minn);
        }
        else{
            int minn=Integer.MAX_VALUE;
            for(int i=0;i<s.length;++i){
                if(s[i].equals(w1)) {
                	f=i;
                }
                else if(s[i].equals(w2)) {
                	e=i;
                }
                if(f!=-1 && e!=-1) minn=Math.min(minn,Math.abs(f-e));
            }
            System.out.println(minn);
        }
    }
}