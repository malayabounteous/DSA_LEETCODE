class Solution {
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (i < n && nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            }
        }
        for (int j = 1; j <= n; ++j) {
            if (nums[j - 1] != j)
                return j;
        }
        return n + 1;
    }
}