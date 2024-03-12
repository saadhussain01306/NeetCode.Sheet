class Solution {
    public int minEatingSpeed(int[] p, int h) {
        // the set for k would lie between 1 and the highest number in the piles array
        // i.e the speed is in between 1 per hour or highest piles per hour
        int max = p[0];

        for (int n : p) {
            if (n > max) {
                max = n;
            }
        }

        int left = 1;
        int right = max;

        int res = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (is_eatable(p, mid, h)) {
                res = mid;
                // check if the time can still be reduced in the first half of the interval
                right = mid - 1;
            } else {
                left = mid + 1;
                // increase the time as the time of eating per hour is not enough
            }
        }

        return res;
    }

    private boolean is_eatable(int p[],int eating_time,int hours){
        int eating_hours=0;

        for(int i=0;i<p.length;i++){
            eating_hours+=p[i]/eating_time;
            if(p[i]%eating_time!=0){
                eating_hours+=1;
                // if we are left out with the reaminder after eating the current pile 
                // then increase the eating_hour by one

            }

            if(eating_hours>hours){
                return false;
                // this rate uses more then the specified time so discard this eating time 
            }
        }

        return true;
    }
}
