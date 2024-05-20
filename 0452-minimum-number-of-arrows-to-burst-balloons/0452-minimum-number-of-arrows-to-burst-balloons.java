class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        // Sort the points based on the end coordinate
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;  // Start with one arrow
        int arrowPosition = points[0][1];  // Position the first arrow at the end of the first balloon

        for (int i = 1; i < points.length; i++) {
            // If the current balloon starts after the last arrow position, shoot a new arrow
            if (points[i][0] > arrowPosition) {
                arrows++;
                arrowPosition = points[i][1];  // Update the position of the new arrow
            }
        }

        return arrows;
    }
}
