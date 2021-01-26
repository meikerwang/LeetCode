class Solution {
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        // 先上下对称 然后对角线
        // 1,2,3    7,8,9    7,4,1
        // 4,5,6 => 4,5,6 => 8,5,2
        // 7,8,9    1,2,3    9,6,3
        for(int i=0; i<N/2; i++){
            for(int j=0; j<N; j++){
                // 上下对称, 交换matrix[i][j] 和 matrix[N-1-i][j]
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[N-1-i][j];
                matrix[N-1-i][j] = tmp;
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<i; j++){
                // 对角线对称, 交换matrix[i][j] 和 matrix[j][i]
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}