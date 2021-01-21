class Solution {
    // 每次比较过程都可以剔除一行或者一列，不断缩小范围
    // 时间复杂度O(n), 空间复杂度O(1)
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        if(target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length-1]){
            return false;
        }
        int i = matrix.length - 1;
        int j = 0;
        while(i >=0 && j <= matrix[0].length - 1){
            if(matrix[i][j] == target){
                return true;
            }
            else if(matrix[i][j] > target){
                i--; // 当前数字大, 则表明当前行不符合条件
            }
            else{
                j++; // 当前数字小, 则表明当前列不符合条件
            }
        }
        return false;
    }
}