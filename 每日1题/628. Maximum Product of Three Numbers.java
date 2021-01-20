class Solution {

    // 如果数组中全是非负数，则排序后最大的三个数相乘即为最大乘积
    // 如果全是非正数，则最大的三个数相乘同样也为最大乘积。
    // 如果数组中有正数有负数，则最大乘积既可能是三个最大正数的乘积，
    // 也可能是两个最小负数（即绝对值最大）与最大正数的乘积
    public int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        for(int elem: nums){

            if(elem < min1){
                min2 = min1;
                min1 = elem;
            }
            else if(elem < min2){
                min2 = elem;
            }

            if(elem > max1){
                max3 = max2;
                max2 = max1;
                max1 = elem;
            }
            else if(elem > max2){
                max3 = max2;
                max2 = elem;
            }
            else if(elem > max3){
                max3 = elem;
            }
        }

        return Math.max(min1 * min2 * max1, max3 * max2 * max1);
    }
}