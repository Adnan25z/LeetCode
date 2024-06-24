class StockSpanner {
    private Stack<int[]> stack;
    
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1; // The span for the current price starts at 1
        
        // Calculate the span for the current price
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1]; // Add the span of all popped elements
        }
        
        // Push the current price and its calculated span to the stack
        stack.push(new int[]{price, span});
        
        // Return the span for the current price
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */