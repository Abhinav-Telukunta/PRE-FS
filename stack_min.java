/*Design a stack such that minimum element should be retrieved in O(1)
Input consists of numbers 1,2,3,4 and 0
1 ele stands for push ele into stack
2 stands for pop
3 stands for printing top element
4 stands for minimum element fetching and printing
0 stands for termination of program
*/
import java.util.*;
public class stack_min{
    public static void main(String args[]){
        Stack<Integer>st=new Stack<Integer>();
        Scanner sc=new Scanner(System.in);
        int minn=Integer.MAX_VALUE;
        while(true){
        String[] s=sc.nextLine().split(" ");
        if(s[0].equals("1")){
            if(Integer.parseInt(s[1])<minn){
                st.push(minn);
                st.push(Integer.parseInt(s[1]));
                minn=Integer.parseInt(s[1]);
            }
            else st.push(Integer.parseInt(s[1]));
        }
        if(s[0].equals("2")){
            if(st.pop()==minn){
                minn=st.pop();
            }
        }
        if(s[0].equals("3")){
            System.out.println(st.peek());
        }
        if(s[0].equals("4")){
            System.out.println(minn);
        }
        if(s[0]=="0") System.exit(0);
        }
        
    }
}
