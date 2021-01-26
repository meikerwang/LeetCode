class Solution {
    public boolean oneEditAway(String first, String second) {
        int n1 = first.length(), n2 = second.length();
        // 两者长度相差不超过1
        if(Math.abs(n1 - n2) > 1){
            return false;
        }
        if(n1 < n2){
            return oneEditAway(second, first);
        }
        // 此时存在n1 >= n2
        for(int i=0; i<n2; i++){
            // 当他们字符不相等 分为长度相等或不相等的情况
            if(first.charAt(i) != second.charAt(i)){
                if(n1 == n2){
                    // 长度相同的串, 则跳过当前字符, 两者之后所有字符都相同
                    return first.substring(i+1, n1).equals(second.substring(i+1, n2));
                }
                else{
                    // 长度不同的串, 则first需要从下一个字符开始, second不需要跳过当前字符
                    return first.substring(i+1, n2+1).equals(second.substring(i, n2));
                }
            }
        }
        return true;
    }
}