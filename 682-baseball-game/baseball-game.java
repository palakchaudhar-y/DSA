class Solution {
    public int calPoints(String[] operations) {
       Stack<Integer> st=new Stack<>();
       for(int i=0;i<operations.length;i++){
        String s=operations[i];
        if(s.equals("+")){
            int b=st.pop();
            int a=st.pop();
            st.push(a);
            st.push(b);
            st.push(a+b);
        }
        else if(s.equals("D")){
           int a=st.peek();
           st.push(a*2); 
        }
        else if(s.equals("C")){
            st.pop();
        }
        
       
       else{
        st.push(Integer.parseInt(s));
       }
       }
       int sum=0;
       while(!st.isEmpty()){
        sum+=st.pop();
       }
       
       return sum;
    }
}