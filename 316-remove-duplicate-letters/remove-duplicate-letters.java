class Solution {
    public String removeDuplicateLetters(String s) {
        int n=s.length();
        Stack<Character> st=new Stack<>();
        int[] last = new int[26];
        boolean[] used = new boolean[26];
        for(int i=0;i<n;i++){
        last[s.charAt(i)-'a']=i;
        }
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(used[ch-'a']){
                continue;
            }
            while(!st.isEmpty() && st.peek()>ch && last[st.peek()-'a']>i){
                used[st.pop()-'a']=false;
            }
            st.push(ch);
            used[ch-'a']=true;
        }
        StringBuilder sd=new StringBuilder();
        while(!st.isEmpty()){
            sd.append(st.pop());
        }
        return sd.reverse().toString();        
    }
}