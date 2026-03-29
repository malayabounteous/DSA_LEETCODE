class Solution {
    public int maxArea(int[] height) {
        
        int n=height.length;

        int ans=0;
        int i=0,j=n-1;
        while(i<j){
            int len=Math.min(height[i],height[j]);

            ans=Math.max(ans,(j-i)*len);
            if(height[i]<height[j])i++;
            else j--;
        }
        return ans;
    }
}