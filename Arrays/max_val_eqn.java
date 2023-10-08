// https://leetcode.com/problems/max-value-of-equation/

package Arrays;

import java.util.PriorityQueue;

public class max_val_eqn {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int ans = Integer.MIN_VALUE;
        int n = points.length;

        // Using equation: Yi + Yj + |Xi - Xj| = Yi - Xi + (Yj + Xj)
        // In Priority queue we are storing two values:
        //     first = Yi - Xi
        //     second = Xi
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < n; i++) {
            while (!pq.isEmpty() && (points[i][0] - pq.peek()[1]) > k) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                ans = Math.max(ans, (points[i][0] + points[i][1] + pq.peek()[0]));
            }
            pq.offer(new int[]{points[i][1] - points[i][0], points[i][0]});
        }

        return ans;
    }
}
