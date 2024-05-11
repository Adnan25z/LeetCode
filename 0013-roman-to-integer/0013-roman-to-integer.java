class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);
        
        int sum = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            // Get value of the current numeral
            int value = romanValues.get(s.charAt(i));
            
            // If the next numeral is larger, this numeral is subtracted
            if (i + 1 < n && value < romanValues.get(s.charAt(i + 1))) {
                sum -= value;
            } else {
                sum += value;
            }
        }
        return sum;
    }
}
