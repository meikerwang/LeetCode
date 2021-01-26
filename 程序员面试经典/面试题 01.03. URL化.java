class Solution {
    public String replaceSpaces(String S, int length) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<length; i++){
            char ch = S.charAt(i);
            if(ch == ' '){
                sb.append("%20");
            }
            else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}