
public class SortColors {

	public void sortColors(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        
        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        
        int i = 0;
        int j = 0;
        while (j <= 2) {
            if (count[j] != 0) {
                nums[i++] = j;
                count[j]--;
            } else {
                j++;
            }
        }
    }
}
