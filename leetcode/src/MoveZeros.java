
public class MoveZeros {

	public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        if (nums.length == 1) {
            return;
        }
        
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] == 0 && nums[j] != 0) {
                nums[i] = nums[j];
                nums[j] = 0;
                i++;
            } else if (nums[i] != 0) {
                i++;
            }
        }
    }
}
