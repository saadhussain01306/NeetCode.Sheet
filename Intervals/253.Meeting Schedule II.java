/*

Given an array of meeting time interval objects consisting of start and end times [[start_1,end_1],[start_2,end_2],...] (start_i < end_i), find the minimum number of days required to schedule all meetings without any conflicts.

Example 1:

Input: intervals = [(0,40),(5,10),(15,20)]

Output: 2
Explanation:
day1: (0,40)
day2: (5,10),(15,20)

Example 2:

Input: intervals = [(4,9)]

Output: 1
Note:

(0,8),(8,10) is not considered a conflict at 8
Constraints:

0 <= intervals.length <= 500
0 <= intervals[i].start < intervals[i].end <= 1,000,000


*/


/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int len=intervals.size();
        if(len==0){
            return 0;
        }
       
        int[] start_time= new int[len];
        int[] end_time= new int[len];
        int index=0;

        for(Interval in:intervals){
           start_time[index]=in.start;
           end_time[index]=in.end;
           index++;
        }

        Arrays.sort(start_time);
        Arrays.sort(end_time);

        int s=0;
        int e=0;
        int count=0;
        int res=0;

        while(s<len){
            if(start_time[s]<end_time[e]){
                count++;
                s++;//more than one meeting going on
            }
            else{
                count--;//the last meeting has ended check for the next end time
                e++;
            }
            
            res=Math.max(res,count);
        }

        return res;
    }
}
