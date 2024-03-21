class Solution {
    public boolean isSubsequence(String s, String t) {
        int sPointer = 0, tPointer = 0;
        while(tPointer < t.length()){
            if(sPointer<s.length() && s.charAt(sPointer) == t.charAt(tPointer)){
                sPointer++;
            }
            tPointer++;
        }
        return sPointer == s.length();
    }
}