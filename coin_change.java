import java.util.*;
class coin_change{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String[] s=sc.nextLine().split(" ");
        ArrayList<Integer>notes=new ArrayList<Integer>();
        for(int i=0;i<s.length;++i){
           notes.add(Integer.parseInt(s[i]));
        }
        int amt=sc.nextInt();
        int n=amt+1;
        int[]dp=new int[n];
        Arrays.fill(dp,amt+1);
        for(int i=0;i<notes.size();++i){
            int val=notes.get(i);
            dp[val]=1;
            for(int j=val;j<=amt;++j){
                dp[j]=Math.min(dp[j],dp[j-val]+1);
            }
            /*for(int k=0;k<amt+1;++k){
                System.out.print(dp[k]+" ");
            }
            System.out.println();*/
        }
        if(dp[amt]==amt+1) System.out.println(-1);
        else System.out.println(dp[amt]);
        System.out.println(Integer.MAX_VALUE+1);
    }
}