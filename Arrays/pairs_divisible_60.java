// https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/

package Arrays;

public class pairs_divisible_60 {
    public int numPairsDivisibleBy60(int[] time) {
        int n = time.length;

        long count[] = new long[60];

        for(int i=0; i<n; i++){
            count[time[i]%60]++;
        }

        long ans = 0;

        for(int i=1; i<30; i++){
            ans += count[i]*count[60-i];
        }
        ans += ((count[0]*(count[0] -1))/2) + ((count[30]*(count[30] -1))/2);
        return (int)ans;
    }
}
