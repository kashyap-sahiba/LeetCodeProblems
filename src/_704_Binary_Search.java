public class _704_Binary_Search {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left<=right){
            int mid = (left + right)/2;

            if(target == nums[mid]){
                return mid;
            }else if(target<nums[mid]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1,0,3,5,9,12};
        int target = 9;
        int answer = 4;
        int result = search(arr,target);
        if(result==answer){
            System.out.println("Test Case Passed");
        }else{
            System.out.println("Test Case Failed");
        }
    }
}
