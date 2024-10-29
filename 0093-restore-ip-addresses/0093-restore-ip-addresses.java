class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(result, s, 0, "", 0);
        return result;
    }
    
    private void backtrack(List<String> result, String s, int index, String currentIP, int segment) {
        // Base cases
        if (segment == 4 && index == s.length()) {
            result.add(currentIP);
            return;
        }
        if (segment == 4 || index == s.length()) return;
        
        // Try to place 1, 2, or 3 digits in each segment
        for (int len = 1; len <= 3; len++) {
            if (index + len > s.length()) break;
            String part = s.substring(index, index + len);
            int partInt = Integer.parseInt(part);
            
            // Check if part is valid (0-255, no leading zeros unless single '0')
            if (partInt > 255 || (part.length() > 1 && part.startsWith("0"))) continue;
            
            // Build the new IP segment
            String newIP = segment == 0 ? part : currentIP + "." + part;
            backtrack(result, s, index + len, newIP, segment + 1);
        }
    }
}
