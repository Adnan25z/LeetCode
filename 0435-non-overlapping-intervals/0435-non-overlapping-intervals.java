class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // Sort intervals based on their end times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int lastEnd = intervals[0][1];

        // Iterate through the intervals starting from the second one
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < lastEnd) {
                // There is an overlap
                count++;
            } else {
                // No overlap, update the end time to be the end of the current interval
                lastEnd = intervals[i][1];
            }
        }

        return count;
    }
}
