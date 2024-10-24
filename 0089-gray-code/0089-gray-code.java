class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);  // Initialize the list with 0 as the first element of the Gray code sequence.
        
        // Iteratively generate the sequence for all n bits.
        for (int i = 0; i < n; i++) {
            int addOn = 1 << i;  // This is the value to add to each mirrored element (1 << i is a bit shift).
            int currentSize = result.size();
            
            // Reflect the current list and add 'addOn' to each reflected element.
            for (int j = currentSize - 1; j >= 0; j--) {
                result.add(result.get(j) + addOn);
            }
        }
        
        return result;
    }
}
