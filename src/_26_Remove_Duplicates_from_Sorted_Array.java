public class _26_Remove_Duplicates_from_Sorted_Array {
    public static int removeDuplicates(int[] nums) {
        int i =0;
        int j=1;
        int unique=1;
        while(j<=nums.length-1){
            if(nums[i]==nums[j]){
                j++;
            }else{
                unique++;
                int temp=nums[j];
                nums[j]=nums[i+1];
                nums[i+1]=temp;
                i++;
                j++;
            }
        }

        return unique;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(arr));
    }
}
