class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> duplicates = new HashSet<>();
        for(int num : nums){
            if(duplicates.contains(num)){
                return true;
            }
            duplicates.add(num);
        }
        return false;
    }
}
