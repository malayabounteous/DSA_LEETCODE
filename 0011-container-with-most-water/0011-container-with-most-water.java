class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int ans=0;
        int i=0,j=n-1;
        
        while(i<j)
        {
            int area=Math.min(height[i],height[j])*(j-i);
            ans=Math.max(ans,area);
            if(height[i]<height[j])
            i++;
            else
            j--;
        }
        return ans;
    }
}