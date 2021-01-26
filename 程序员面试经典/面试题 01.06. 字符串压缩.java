class Solution {
    // 我们从左往右遍历字符串，用 ch 记录当前要压缩的字符，count 记录 ch 出现的次数
    // 如果当前枚举到的字符 cur 等于 ch ，我们就更新计数
    // 否则我们按题目要求将 count 以及 cur 更新到答案里
    public String compressString(String S) {
        if(S.length() == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char ch = S.charAt(0);
        for(int i=1; i<S.length(); i++){
            char cur = S.charAt(i);
            if(cur != ch){
                sb.append(ch).append(count);
                ch = cur;
                count = 1;
            }
            else{
                count++;
            }
        }
        sb.append(ch).append(count);
        String result = sb.toString();
        if(result.length() < S.length()){
            return result;
        }
        else{
            return S;
        }
    }
}