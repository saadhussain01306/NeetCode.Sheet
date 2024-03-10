class Solution {
    public int trap(int[] height) {
        Stack<Integer> s = new Stack<>();

        int cur = 0;
        int water = 0;

        while (cur < height.length) {
            while (!s.isEmpty() && height[cur] > height[s.peek()]) {
                int top = s.pop(); 
                if (s.isEmpty()) {
                    break;
                }
                int d = cur - s.peek() - 1;
                int content = d * (Math.min(height[cur], height[s.peek()]) - height[top]);
                water += content;
            }
            s.push(cur++);
        }

        return water;
    }
}
