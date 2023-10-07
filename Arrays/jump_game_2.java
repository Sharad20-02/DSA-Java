// https://leetcode.com/problems/jump-game-ii/

package Arrays;

public class jump_game_2 {
    public int jump(int[] nums) {
        int jumps = 0;
        int currEnd = 0;
        int currFarthest = 0;

        for(int i=0; i<nums.length-1; i++){
            currFarthest = Math.max(currFarthest, i + nums[i]);
            if(i == currEnd){
                currEnd = currFarthest;
                jumps++;
            }
        }
        return jumps;
    }
}
