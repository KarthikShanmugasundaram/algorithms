
public class BinarySearch {

	public int search(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        
        if (nums.length == 1 && nums[0] == target) {
            return 0;
        } else if (nums.length == 1){
            return -1;
        }
        
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
        	int mid = left + (right - left) / 2;
        	if (nums[mid] == target) {
        		return mid;
        	} else if (nums[mid] < target) {
        		left = mid + 1;
        	} else {
        		right = mid;
        	}
        }
        
        return -1;
    }
	
	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		
		int nums[] = {1,2,3,4,5,6,7};
		System.out.println("Search: 2: " + bs.search(nums, 2));
		System.out.println("Search:1: " + bs.search(nums, 1));
		System.out.println("Search:7: " + bs.search(nums, 7));
		System.out.println("Search:4: " + bs.search(nums, 4));
		System.out.println("Search:3: " + bs.search(nums, 3));
		System.out.println("Search:5: " + bs.search(nums, 5));
		System.out.println("Search:6: " + bs.search(nums, 6));
		System.out.println("Search:8: " + bs.search(nums, 8));
	}
}
