import java.util.Arrays;
import java.util.Stack;

public class _853_Car_Fleet {
    public static int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 1) return 1;
        Stack<Double> stack = new Stack<>();
        int[][] combine = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            combine[i][0] = position[i];
            combine[i][1] = speed[i];
        }

        Arrays.sort(combine, java.util.Comparator.comparingInt(o -> o[0]));
        for (int i = combine.length - 1; i >= 0; i--) {
            double currentTime = (double) (target - combine[i][0]) /
                    combine[i][1];
            if (!stack.isEmpty() && currentTime <= stack.peek()) {
                continue;
            } else {
                stack.push(currentTime);
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        /*
        * target = 12
        * position = [10,8,0,5,3]
        * speed = [2,4,1,1,3]
        * */

        int target = 12;
        int[] position = new int[]{10,8,0,5,3};
        int[] speed = new int[]{2,4,1,1,3};

        int result = carFleet(target,position,speed);
        System.out.println(result);

        if(result==3){
            System.out.println("Test Case Passed");
        }else{
            System.out.println("Test Case Failed");
        }
    }
}
