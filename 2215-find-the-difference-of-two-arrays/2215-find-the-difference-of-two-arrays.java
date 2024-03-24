class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // Step 1: Convert arrays to sets
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            set2.add(num);
        }
        
        // Step 2: Find unique elements
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>()); // answer[0]
        answer.add(new ArrayList<>()); // answer[1]
        
        // Unique in nums1
        for (int num : set1) {
            if (!set2.contains(num)) {
                answer.get(0).add(num);
            }
        }
        
        // Unique in nums2
        for (int num : set2) {
            if (!set1.contains(num)) {
                answer.get(1).add(num);
            }
        }
        
        return answer;
    }
}