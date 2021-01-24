// https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return nums.length;
        }
        int max = 1;
        int count = 1;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i+1] > nums[i]){
                count += 1;
            }
            else{
                count = 1;
            }
            max = Math.max(max, count);
        }

        return max;
    }
}