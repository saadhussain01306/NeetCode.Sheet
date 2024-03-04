class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score=0;
        
        int left=0;
        int right=tokens.length-1;
        int max_score=0;

        while(left<=right){
            if(power>=tokens[left]){
                power-=tokens[left];
                left++;
                score++;
                max_score=Math.max(max_score,score);
            }
            else if(score>0){
                power+=tokens[right];
                score--;
                right--;
            }
            else{
                break;
            }
        }

        return max_score;

    }
}
