class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            List<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        char ch=digits.charAt(0);
        String ros=digits.substring(1);
        List<String> rres=letterCombinations(ros);
        List<String> mres=new ArrayList<>();

        String[] keypad = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        String digitsofch=keypad[ch-'0'];
        for(int i=0;i<digitsofch.length();i++){
            char cdigit=digitsofch.charAt(i);
            for(String rstr:rres){
                mres.add(cdigit+rstr);
            }
        }  
        return mres;
    }
}