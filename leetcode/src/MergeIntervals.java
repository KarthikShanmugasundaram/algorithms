import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0  || intervals.size() == 1) {
            return intervals;
        }
        
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval val1, Interval val2) {
                if (val1.start != val2.start) {
                    return val1.start - val2.start;
                } else {
                    return val1.end - val2.end;
                }
            }
        });
        
        List<Interval> result = new ArrayList<Interval>(intervals.size());
        Interval prev = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (current.start <= prev.end) {
                Interval interval = new Interval(prev.start, Math.max(current.end, prev.end));
                prev = interval;
            } else {
                result.add(prev);
                prev = current;
            }
        }
        result.add(prev);
        
        return result;
    }
}

class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
}
