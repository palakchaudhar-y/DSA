class Solution {
    public int evalRPN(String[] tokens) {
      Stack<Integer> st=new Stack<>();
      for(int i=0;i<tokens.length;i++){
        String s=tokens[i];
        if(s.equals("+")||s.equals("-")||s.equals("/")||s.equals("*")){
            int b=st.pop();
            int a=st.pop();
            int result=0;
            if(s.equals("+")) result=a+b;
            else if(s.equals("-")) result=a-b;
            else if(s.equals("*")) result=a*b;
            else result=a/b;
        
        st.push(result);
      }
        else{
            st.push(Integer.parseInt(s));
        }}
        return st.peek();
    }
}