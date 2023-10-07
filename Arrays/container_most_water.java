// https://leetcode.com/problems/container-with-most-water/

package Arrays;

public class container_most_water {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while(left<right){
            int w = right - left;
            int h = Math.min(height[left], height[right]);
            int a = w * h;
            max = Math.max(a, max);

            if(height[left] > height[right]){
                right--;
            }else if(height[left] < height[right]){
                left++;
            }else{
                left++;
                right--;
            }
        }
        return max;
    }
}
