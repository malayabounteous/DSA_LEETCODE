class Solution {
    public int findMin(int[] nums) {

        int n = nums.length;

        int left = 0, right = n - 1;
        int mini = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;

            mini = Math.min(mini, nums[mid]);

            if (nums[mid] < nums[right]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return mini;
    }
}