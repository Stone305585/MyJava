package interview;

/**
 * Created by Stone on 2016/7/6.
 */
public class HouseRobber {

    public static int rob(int[] nums){

        if(nums == null || nums.length == 0){
            return 0;
        }

        if(nums.length == 1){
            return nums[0];
        }

        int maxProfit[] = new int[nums.length];
        maxProfit[0] = nums[0];
        maxProfit[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; ++i){
            maxProfit[i] = Math.max(maxProfit[i - 2] + nums[i], maxProfit[i - 1]);
        }
        return maxProfit[nums.length - 1];
    }

    public static void main(String[] args){
//        System.out.print(rob(new int[]{2,4,1,5,7,3,9,4,3}));
//        System.out.print(78);
        System.out.print(isPowerOfFour(12));
    }

    /**
     * 证明一个数是4的幂次i
     * @param num
     * @return
     */
    public static boolean isPowerOfFour(int num) {

        while(num>1){
            if((num & 11) != 0) return false;
            num>>=2;
        }
        return num==1;
    }
}
