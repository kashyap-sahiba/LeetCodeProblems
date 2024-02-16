import javafx.util.Pair;

import java.util.Stack;

public class _84_Largest_Rectangle_in_Histogram {

    public static int largestRectangleArea(int[] heights) {

        int area =0;
        Stack<Pair<Integer,Integer>> stack = new Stack();
        int start;
        int n = heights.length;

        for(int i =0;i<n;i++){
            int currHt = heights[i];
            start = i;
            while(!stack.isEmpty() && stack.peek().getValue()>currHt){
                Pair<Integer,Integer> pair = stack.pop();
                int index = pair.getKey();
                int h = pair.getValue();
                area = Math.max(area,(i-index)*h);
                start=index;
            }

            stack.push(new Pair(start,currHt));
        }

        while(!stack.isEmpty()){
            Pair<Integer,Integer> pair = stack.pop();
            int index = pair.getKey();
            int h = pair.getValue();
            area = Math.max(area,(n-index)*h);
        }

        return area;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,1,5,6,2,3};
        int ans = 10;
        int result = largestRectangleArea(arr);
        if(ans==result){
            System.out.println("Test Case Passed");
        }else{
            System.out.println("Test Case Failed");
        }
    }

}
