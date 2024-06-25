class Solution {
       public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        long totalCost = 0;

        // Priority queues to store the smallest costs from both ends
        PriorityQueue<int[]> leftHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> rightHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // Initialize the left heap with the first 'candidates' elements
        for (int i = 0; i < candidates; i++) {
            leftHeap.offer(new int[]{costs[i], i});
        }

        // Initialize the right heap with the last 'candidates' elements
        for (int i = Math.max(candidates, n - candidates); i < n; i++) {
            rightHeap.offer(new int[]{costs[i], i});
        }

        int leftIndex = candidates;
        int rightIndex = n - candidates - 1;

        // Perform k hiring sessions
        for (int i = 0; i < k; i++) {
            if (!leftHeap.isEmpty() && (rightHeap.isEmpty() || leftHeap.peek()[0] <= rightHeap.peek()[0])) {
                // Choose the minimum cost worker from the left heap
                int[] candidate = leftHeap.poll();
                totalCost += candidate[0];

                // If there's a next candidate from the left side, add to the left heap
                if (leftIndex <= rightIndex) {
                    leftHeap.offer(new int[]{costs[leftIndex], leftIndex});
                    leftIndex++;
                }
            } else {
                // Choose the minimum cost worker from the right heap
                int[] candidate = rightHeap.poll();
                totalCost += candidate[0];

                // If there's a next candidate from the right side, add to the right heap
                if (leftIndex <= rightIndex) {
                    rightHeap.offer(new int[]{costs[rightIndex], rightIndex});
                    rightIndex--;
                }
            }
        }

        return totalCost;
    }
}
