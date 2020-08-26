/*Bantu has an habit of writing the content vertically

For example:
Given line is "AMUL BABY"
He will write it as
	AB
	MA
	UB
	LY
	
You will be given a list of words. 
Your task is to print the words vertically like Bantu.

Return the words as a list of strings, complete with spaces when is necessary. 
(Trailing spaces are not allowed).

Note:
Each word in the list, should be in single column.

Input Format:
-------------
A string S, contains space separated words.

Output Format:
--------------
Print the the words as a list of strings.
As shown below.

Sample Input-1:
---------------
HOW ARE YOU

Sample Output-1:
----------------
HAY,ORO,WEU,

Explanation: 
------------
Each word is printed vertically. 
	 "HAY"
	 "ORO"
	 "WEU"


Sample Input-2:
---------------
TO BE OR NOT TO BE

Sample Output-2:
----------------
TBONTB,OEROOE,   T,

Explanation: 
------------
Trailing spaces is not allowed. 
	"TBONTB"
	"OEROOE"
	"   T"


Sample Input-3:
---------------
CONTEST IS COMING

Sample Output-3:
----------------
CIC,OSO,N M,T I,E N,S G,T,
*/
import java.util.*;
public class vertical{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String []s=sc.nextLine().split(" ");
        int maxx=Integer.MIN_VALUE;
        for(int i=0;i<s.length;++i){
            if(s[i].length()>maxx) maxx=s[i].length();
        }
        ArrayList<String>ans=new ArrayList<String>();
        for(int i=0;i<maxx;++i){
            String sub="";
            for(int j=0;j<s.length;++j){
                if(i>=s[j].length()) sub+=' ';
                else sub+=s[j].charAt(i);
            }
            int idx=0;
            for(int k=sub.length()-1;k>=0;--k){
                if(sub.charAt(k)!=' '){
                    idx=k;
                    break;
                }
            }
            sub=sub.substring(0,idx+1);
            ans.add(sub);
            
        }
        for(int i=0;i<ans.size();++i){
            System.out.print(ans.get(i)+",");
        }
    }
}