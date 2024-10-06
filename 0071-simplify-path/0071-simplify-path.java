class Solution {
    public String simplifyPath(String path) {
        // Initialize a stack to store the valid directories
        Stack<String> stack = new Stack<>();
        
        // Split the path by "/" to process each component
        String[] components = path.split("/");
        
        // Process each component
        for (String component : components) {
            if (component.equals("") || component.equals(".")) {
                // Ignore empty components and current directory (.)
                continue;
            } else if (component.equals("..")) {
                // Pop from stack if possible (i.e., go up one level)
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Push valid directory names onto the stack
                stack.push(component);
            }
        }
        
        // Build the simplified path from the stack
        StringBuilder simplifiedPath = new StringBuilder();
        for (String dir : stack) {
            simplifiedPath.append("/").append(dir);
        }
        
        // Return the root "/" if the stack is empty
        return simplifiedPath.length() > 0 ? simplifiedPath.toString() : "/";
    }
}
