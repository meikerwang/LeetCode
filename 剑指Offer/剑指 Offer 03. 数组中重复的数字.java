class Solution {
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int elem: nums){
            if(set.contains(elem)){
                return elem;
            }
            set.add(elem);
        }
        return -1;
    }
}