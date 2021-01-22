class Solution {
    // 当前位 = (A 的当前位 + B 的当前位 + 进位carry) % 10
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> result = new ArrayList<>();
        int carry = 0;
        for(int i=A.length -1; i>=0; i--){
            int sum = (carry + A[i] + K % 10) % 10;
            carry = (carry + A[i] + K % 10) / 10;
            result.add(sum);
            K = K / 10;
        }
        while(K != 0 || carry != 0){
            int sum = (carry + K % 10) % 10;
            carry = (carry + K % 10) / 10;
            result.add(sum);
            K = K / 10;
        }
        Collections.reverse(result);
        return result;
    }
}