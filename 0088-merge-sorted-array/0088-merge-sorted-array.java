class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // Initialize pointers
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

        // Merge nums1 and nums2 starting from the end
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }

        // Copy remaining elements of nums2 if any
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p--;
            p2--;
        }
    }
}