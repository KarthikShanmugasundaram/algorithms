
public class SearchInRotatedSortedArray {

	public int search(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }
        
        int left = 0;
        int right = nums.length -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            }
            
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && nums[mid] > target) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            } else {
                if (nums[right] >= target && nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid-1;
                }
            }
        }
        
        return -1;    
    }
}
