class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for(int i = 0; i<flowerbed.length && count < n; i++){
            if(flowerbed[i]==0){
                boolean checkPrev = (i==0) || (flowerbed[i-1]==0);
                boolean checkNext = (i==flowerbed.length-1) || (flowerbed[i+1]==0);
                
                if(checkPrev && checkNext){
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
            return count >= n;
    }
}