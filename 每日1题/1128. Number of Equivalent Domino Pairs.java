class Solution {
    // 二元对中的元素均不大于 99，因此我们可以将每一个二元对拼接成一个两位的正整数，即(x,y)→10x+y
    // 这样就无需使用哈希表统计元素数量，而直接使用长度为 100 的数组
    // 时间复杂度O(n)
    // 空间复杂度O(1) hashmap长度最大不超过100
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int[] dom : dominoes){
            int num = (dom[0] < dom[1]) ? (dom[0] * 10 + dom[1]) : (dom[0] + dom[1] * 10);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int sum = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int k = entry.getKey();
            int v = entry.getValue();
            sum = sum + v * (v - 1) / 2;
        }
        return sum;
    }
}