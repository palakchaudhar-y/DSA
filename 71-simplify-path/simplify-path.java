class Solution {
    public String simplifyPath(String path) {
        Stack<String> st=new Stack<>();
        String[] parts=path.split("/");
        for(int i=0;i<parts.length;i++){
            String part=parts[i];
            if(part.equals("") || part.equals(".")){
                continue;
            }else if(part.equals("..")){
                if(!st.isEmpty()){
                st.pop();}
            }
            else{
                st.push(part);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(String part : st) { 
            sb.append("/"); 
            sb.append(part);
         }

        if(sb.length()==0){
        return "/";
    }
        return sb.toString();
    }
}