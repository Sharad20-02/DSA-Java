// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/

package Arrays;

public class max_points_from_cards {
     public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int res = 0;
        int st = k-1;
        int ed = cardPoints.length - 1;

        for(int i=0; i<k; i++){
            sum += cardPoints[i];
        }

        for(int i=0; i<k; i++){
            res = Math.max(res, sum);
            sum -= cardPoints[st];
            st--;
            sum += cardPoints[ed];
            ed--; 
        }
        res = Math.max(res, sum);
        return res;
    }
}
