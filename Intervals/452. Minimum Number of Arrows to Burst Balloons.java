class Solution {
    public int findMinArrowShots(int[][] points) {
        int n=points.length;
        if(n==1){
            return 1;
        }
        Arrays.sort(points,Comparator.comparingInt(i->i[0]));
        int arrows=1;
        int common_interval[]=points[0];

        for(int i=0;i<n;i++){
            int cur_start_point=points[i][0];
            int cur_end_point=points[i][1];

            // if the intervals are overlapping
            if(cur_start_point<=common_interval[1]){
                common_interval[0]=Math.max(common_interval[0],cur_start_point);
                common_interval[1]=Math.min(common_interval[1],cur_end_point);

            }
            else{
                //for non overalpping intervals
                common_interval[0]=cur_start_point;
                common_interval[1]=cur_end_point;
                arrows++;
            }
        }

        return arrows;
    }
}
