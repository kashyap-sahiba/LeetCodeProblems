public class _33_Search_in_Rotated_Sorted_Array {

    public static int search(int[] nums, int target) {
        int left =0;
        int right = nums.length-1;

        while(left<=right){


            int mid = (left+right)/2;

            if(nums[mid]== target){
                return mid;
            }
            if(nums[left]<=nums[mid]){
                if(target>nums[mid] || target < nums[left]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }else{
                if(nums[mid]>target || target > nums[right]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 0;
        int answer = 4;
        int result = search(nums,target);

        if(answer==result){
            System.out.println("Test Case passed");
        }else{
            System.out.println("Test Case Failed");
        }
    }

}
