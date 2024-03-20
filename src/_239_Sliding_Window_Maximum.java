import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class _239_Sliding_Window_Maximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int j = 0;
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!q.isEmpty() && q.peekFirst() < i - k + 1) q.pollFirst();
            while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) q.pollLast();
            q.offer(i);
            if (i >= k - 1) ans[j++] = nums[q.peekFirst()];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k =3;
        int[] ans = new int[]{3,3,5,5,6,7};
        int[] result = maxSlidingWindow(nums,k);

        if(Arrays.equals(result,ans)){
            System.out.println("Passed!");
        }else{
            System.out.println("Failed!");
        }

    }
}
