import java.util.Arrays;

public class _238_Product_of_Array_Except_Self {
    public static int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0]=1;

        for(int i=1;i<nums.length;i++){
            left[i]=left[i-1]*nums[i-1];
        }

        right[nums.length-1]=1;

        for(int j=nums.length-2;j>-1;j--){
            right[j]=right[j+1]*nums[j+1];
        }

        int[] ans = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            ans[i]=left[i]*right[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}
