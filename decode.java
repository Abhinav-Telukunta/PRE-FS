import java.util.*;
public class decode{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        Stack<Character> st=new Stack<Character>();
        for(int i=0;i<s.length();++i){
            if(s.charAt(i)!=']'){
                st.push(s.charAt(i));
            }
            else if(s.charAt(i)==']'){
                StringBuilder sub=new StringBuilder();
                StringBuilder dig=new StringBuilder();
                while(!st.empty() && !Character.isDigit(st.peek())){
                    if(st.peek()!='[') sub.append(st.pop());
                    else if(st.peek()=='[') st.pop();
                }
                while(!st.empty() && Character.isDigit(st.peek())){
                    dig.append(st.pop());
                }
                dig=dig.reverse();
                int digit=Integer.parseInt(dig.toString());
                sub=sub.reverse();
                String temp=sub.toString();
                for(int j=0;j<digit-1;++j) sub.append(temp);
                String res=sub.toString();
                for(int j=0;j<res.length();++j) st.push(res.charAt(j));
                
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!st.empty()){
            sb.append(st.pop());
        }
        sb=sb.reverse();
        System.out.println(sb);
        
    }
}