public class _153_Find_Minimum_in_Rotated_Sorted_Array {

    public static int findMin(int[] nums) {

        int left = 0;
        int right = nums.length-1;
        int res = Integer.MAX_VALUE;

        while(left<=right){

            if(nums[left]<nums[right]){
                return nums[left];
            }

            int mid = (left + right)/2;
            res=Math.min(nums[mid],res);

            if(nums[mid]>=nums[left]){
                left = mid+1;
            }else{
                right = mid;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,8,9,0,1,2,3,4};
        int ans = 0;
        int res = findMin(nums);

        if(ans == res){
            System.out.println("Test Case Passed");
        }else{
            System.out.println("Test Case Failed");
        }
    }
}
