class Solution {
    // 判断是否是回文字符串的排列: 最多有一个字母出现的次数为奇数次(出现在串中间)
    public boolean canPermutePalindrome(String s) {
        int[] count = new int[256];
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            count[(int)ch]++;
        }
        int num = 0;
        for(int i=0; i<count.length; i++){
            if(count[i] % 2 == 0){
                continue;
            }
            num++;
            if(num >= 2){
                return false;
            }
        }
        return true;
    }
}