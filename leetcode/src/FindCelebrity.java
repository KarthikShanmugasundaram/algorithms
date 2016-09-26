/**
 * Relation provided by Leetcode
 */
public class FindCelebrity extends Relation {

	public int findCelebrity(int n) {
        if (n == 0) {
            return -1;
        }
        
        int left = 0;
        int right = n-1;
        while (left < right) {
            boolean flag = knows(left, right);
            if (flag) {
                left++;
            } else {
                right--;
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (i == right) {
                continue;
            }
            
            if (knows(right, i) || !knows(i, right)) {
                return -1;
            } 
        }
        
        return right;
    }
}
