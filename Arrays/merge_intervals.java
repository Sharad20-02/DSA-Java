// https://leetcode.com/problems/merge-intervals/

package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class merge_intervals {
    public int[][] merge(int[][] intervals) {

        class sortByStart implements Comparator<int[]> {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        }

        Arrays.sort(intervals, new sortByStart());
        ArrayList<int[]> mergedIntervals = new ArrayList<>();
        
        for (int i = 0; i < intervals.length; i++) {
            if (mergedIntervals.isEmpty() || intervals[i][0] > mergedIntervals.get(mergedIntervals.size() - 1)[1]) {
                mergedIntervals.add(intervals[i]);
            } else {
                mergedIntervals.get(mergedIntervals.size() - 1)[1] = Math.max(mergedIntervals.get(mergedIntervals.size() - 1)[1], intervals[i][1]);
            }
        }
        
        int[][] arr = mergedIntervals.toArray(new int[0][]);
        return arr;
    }
}
