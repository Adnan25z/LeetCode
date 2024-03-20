class Solution {
    public int compress(char[] chars) {
        int read=0, write=0;
        while(read<chars.length){
            char currentChar = chars[read];
            int count = 0;
            while(read<chars.length && chars[read]==currentChar){
                read++;
                count++;
            }
            chars[write++]=currentChar;
            
            if(count>1){
                for(char c: Integer.toString(count).toCharArray()){
                    chars[write++] = c;
                }
            }
        }
        return write;
    }
}