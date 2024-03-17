class Solution {
    public int[][] merge(int[][] intervals) {

        if(intervals.length<=1){
            return intervals;
        }
        List<int[]>res= new ArrayList<>();
        
        Arrays.sort(intervals,Comparator.comparingInt(i->i[0]));
        
        int[] new_interval=intervals[0];
        res.add(new_interval);

        for(int[] interval:intervals){
            if(interval[0]<=new_interval[1]){
                //[1,3],[2,6]--> [1,6]
                new_interval[1]=Math.max(interval[1],new_interval[1]);
            }
            else{
                new_interval=interval;
                // for the non-overlapping arrays make it the new_inerval as this can also be updated in the further iterations
                res.add(new_interval);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
