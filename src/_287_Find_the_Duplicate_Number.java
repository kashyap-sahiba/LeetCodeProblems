public class _287_Find_the_Duplicate_Number {
    public static int findDuplicate(int[] nums){
        int slow = nums[0];
        int fast = nums[0];

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow!=fast);

        slow = nums[0];

        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1,3,4,2,2};
        int answer = 2;
        int result = findDuplicate(nums);

        if(answer == result){
            System.out.println("Passed!");
        }else{
            System.out.println("Failed!");
        }
    }
}
