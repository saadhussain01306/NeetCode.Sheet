class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean> map=new HashMap<>();
        int max=0;

        for(int i:nums){
            map.put(i,false);
        }

        for(int n:nums){
        
          int curlen=1;

          int prev=n-1; //for the prev elements of n

          while(map.containsKey(prev)&& map.get(prev)==false){
              curlen++;
              map.put(prev,true);
              prev--;
          }
          
          int next=n+1; //for the next elements of n
          while(map.containsKey(next) && map.get(next)==false){
              curlen++;
              map.put(next,true);
              next++;
          }
          max=Math.max(max,curlen);
        }

        return max;
    }
}
