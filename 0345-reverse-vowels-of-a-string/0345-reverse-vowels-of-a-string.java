class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int start=0;
        int end = chars.length -1;
        String vowels = "AEIOUaeiou";
        while(start<end){
            while(start<end && vowels.indexOf(chars[start])==-1){
                start++;
            }
            while(end>start && vowels.indexOf(chars[end])==-1){
                end--;
            }
            if(start<end){
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }
        }
        return new String(chars);
    }
}