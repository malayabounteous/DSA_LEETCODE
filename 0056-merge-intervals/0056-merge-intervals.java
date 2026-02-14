import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        
        // Sort intervals based on starting time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();
        
        int start = intervals[0][0];
        int last = intervals[0][1];
        
        for (int i = 1; i < n; i++) {
            
            if (last < intervals[i][0]) {
                ans.add(new int[]{start, last});
                start = intervals[i][0];
                last = intervals[i][1];
            } else {
                last = Math.max(last, intervals[i][1]);
            }
        }
        
        ans.add(new int[]{start, last});
        
        return ans.toArray(new int[ans.size()][]);
    }
}
