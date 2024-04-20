import java.util.PriorityQueue;
import java.util.HashSet;

class SmallestInfiniteSet {
    private PriorityQueue<Integer> minHeap;
    private HashSet<Integer> inSet;
    private int smallest;

    public SmallestInfiniteSet() {
        minHeap = new PriorityQueue<>();
        inSet = new HashSet<>();
        smallest = 1;  // The smallest positive integer
    }
    
    public int popSmallest() {
        if (!minHeap.isEmpty()) {
            int smallestFromHeap = minHeap.poll();
            inSet.remove(smallestFromHeap);
            return smallestFromHeap;
        } else {
            int currentSmallest = smallest;
            smallest++;  // Increment to the next smallest integer
            return currentSmallest;
        }
    }
    
    public void addBack(int num) {
        if (num < smallest && !inSet.contains(num)) {
            minHeap.offer(num);
            inSet.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
