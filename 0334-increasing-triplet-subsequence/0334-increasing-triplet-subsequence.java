class Solution {
    public boolean increasingTriplet(int[] nums) {
        int First = Integer.MAX_VALUE, Second = Integer.MAX_VALUE;
        for(int num : nums){
            if(num<=First){
                First = num;
            }
            else if(num<=Second){
                Second = num;
            }
            else{
                return true;
            }
        }
        return false;
    }
}