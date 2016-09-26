
public class FindPeekElement {
	
    public int findPeakElement(int[] nums) {
        if (nums == null) {
            return 0;
        }
        
        if (nums.length == 1) {
            return 0;
        } else if (nums.length == 2) {
            return nums[0] <= nums[1] ? 1 : 0;
        }
        
        int left = 0;
        int right = nums.length - 1;
 
        return find(nums, left, right);       
    }
    
    private int find(int[] nums, int left, int right) {        
            int mid = left + (right - left) / 2;
            
            if ((mid == 0 || nums[mid] >= nums[mid-1]) &&  (mid == nums.length-1 || nums[mid] >= nums[mid+1])) {

                return mid;
            } else if (mid > 0 && nums[mid-1] > nums[mid]) {
                return find(nums, left, mid-1);
            } else {
                return find(nums, mid+1, right);
            }
    }

}
