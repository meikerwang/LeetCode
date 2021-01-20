class Solution {
    // Hash
    // 时间复杂度O(n), 空闲复杂度O(1)
    public int findRepeatNumber1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int elem: nums){
            if(set.contains(elem)){
                return elem;
            }
            set.add(elem);
        }
        return -1;
    }

    // 原地置换: 将我们指针对应的元素放到属于他的位置（索引对应的地方）
    // 每个人都有自己的位置，我们需要和别人调换回到属于自己的位置
    // 调换之后，如果发现我们的位置上有人了，则返回
    // 时间复杂度O(n), 空间复杂度O(1)
    public int findRepeatNumber(int[] nums) {
        for(int i=0; i<nums.length; i++){
            while(nums[i] != i){
                if(nums[i] == nums[nums[i]]){
                    // System.out.println(Arrays.toString(nums));
                    return nums[i];
                }
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }
        return -1;
    }
}