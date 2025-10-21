class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        if(intervals == null || intervals.length == 0) return new int[][] {new int[]{newInterval[0],newInterval[1]}};

        if( newInterval == null) return intervals;
        List<int[]> res = new ArrayList<>();
        int i = 0,  n =intervals.length;
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        while(i<n &&  intervals[i][1]< newStart){
                res.add(intervals[i]);
                i++;

        }
        while(i<n && intervals[i][0] <=newEnd ){

          newStart  = Math.min(intervals[i][0], newStart);
          newEnd = Math.max(intervals[i][1],newEnd);
          i++;  
        }
        res.add(new int[]{newStart,newEnd});

        while(i<n){
            res.add(intervals[i]);
            i++;
        }

       return res.toArray(new int[res.size()][]);
    }
}