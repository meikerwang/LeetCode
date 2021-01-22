class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        int[] hash = new int[256];
        // s1和s2的长度首先需要是一致的
        if(s1.length() != s2.length()){
            return false;
        }
        // 元素值表示的是该字符在s1中出现的次数和s2中出现的次数的差值
        for (int i=0; i<s1.length(); i++){
            hash[s1.charAt(i)]++;
            hash[s2.charAt(i)]--;
        }
        // 所有差值应该都是0
        for(int i=0; i<256; i++){
            if(hash[i] != 0){
                return false;
            }
        }
        return true;
    }
}