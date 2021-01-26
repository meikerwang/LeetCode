class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        int M = matrix.length;
        int N = matrix[0].length;
        boolean firstRow = false, firstCol = false;
        // 先判断第一列和第一行是否有0
        for(int i=0; i<M; i++){
            if(matrix[i][0] == 0){
                firstCol = true;
                break;
            }
        }
        for(int j=0; j<N; j++){
            if(matrix[0][j] == 0){
                firstRow = true;
                break;
            }
        }
        // 对于除去第一行第一列, 符合条件的行和列进行标记
        for(int i=1; i<M; i++){
            for(int j=1; j<N; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // 对于除了第一行, 标记为0的行全部置为0
        for(int i=1; i<M; i++){
            // 如果第一列有0, 则对应的行变为0
            if(matrix[i][0] == 0){
                for(int k=1; k<N; k++){
                    matrix[i][k] = 0;
                }
            }
        }

        // 对于除了第一列, 标记为0的列全部置为0
        for(int j=1; j<N; j++){
            // 如果第一行有0, 则对应的列变为0
            if(matrix[0][j] == 0){
                for(int k=1; k<M; k++){
                    matrix[k][j] = 0;
                }
            }
        }

        // 如果第一行有0, 则第一行变为0
        if(firstRow){
            for(int j=0; j<N; j++){
                matrix[0][j] = 0;
            }
        }
        // 如果第一列有0, 则第一列变为0
        if(firstCol){
            for(int i=0; i<M; i++){
                matrix[i][0] = 0;
            }
        }
    }
}