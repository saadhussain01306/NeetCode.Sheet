class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]>res=new ArrayList<>();
        //intervals that do not overlap
        int i=0;
        int n=intervals.length;
         //intervals that do not overlap
        while(i<n && intervals[i][1]<newInterval[0]){
            res.add(intervals[i]);
            i++;
        }

        // take take of the overlapping conditions

        while(i<n && newInterval[1]>=intervals[i][0]){
            newInterval[0]=Math.min(intervals[i][0],newInterval[0]);
            //[3,5] and[4,8]--> 3
            newInterval[1]=Math.max(intervals[i][1],newInterval[1]);
            // [3,5] and[4,8]--> 8
            // hence [3,8];
            i++;
        }

        res.add(newInterval);

        //add the reamoning intervals
        while(i<n){
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][2]);

    }
}
