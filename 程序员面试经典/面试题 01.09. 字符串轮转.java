class Solution {
    public boolean isFlipedString(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        int n = s1.length();
        if(s1.equals(s2)){
            return true;
        }
        // 存在两个子串相等
        for(int i=1; i<s1.length(); i++){
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i, n);
            String s21 = s2.substring(0, n-i);
            String s22 = s2.substring(n-i, n);
            if(s11.equals(s22) && s12.equals(s21)){
                return true;
            }
        }
        return false;
    }
}