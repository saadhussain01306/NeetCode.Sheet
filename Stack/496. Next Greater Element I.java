class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer>map=new HashMap<>();
        Stack<Integer> st=new Stack<>();

        for(int n:nums2){
            while(!st.isEmpty() && st.peek()<n){
              map.put(st.pop(),n);//basically adds the number that is greater than the number as its value
            }
            st.push(n);
        }

        for(int i=0;i<nums1.length;i++){
            nums1[i]=map.getOrDefault(nums1[i],-1);
        }

        return nums1;
        
    }
}
