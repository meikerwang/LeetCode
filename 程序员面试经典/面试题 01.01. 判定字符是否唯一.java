class Solution {
    // 使用数组解决
    // 时间复杂度O(n), 空间复杂度O(1)
    public boolean isUnique(String astr) {
        int[] count = new int[256];
        for(char ch: astr.toCharArray()){
            if(count[ch] == 1){
                return false;
            }
            count[ch] += 1;
        }
        return true;
    }
}