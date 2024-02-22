import java.util.Arrays;

public class _875_Koko_Eating_Bananas {
    public static int minEatingSpeed(int[] piles, int h) {

        int left =1,right=1;

        for(int pile : piles){
            right = Math.max(pile,right);
        }

        while(left<right){
            int hrsSpent = 0;
            int middle =(left + right)/2;

            for(int pile : piles){
                hrsSpent+=Math.ceil((double)pile/middle);
            }

            if(hrsSpent<=h){
                right = middle;
            }else{
                left = middle+1;
            }
        }

        return right;
    }

    public static void main(String[] args) {
        int[] piles = new int[]{3,6,7,11};
        int h = 8;
        int answer = 4;
        int result = minEatingSpeed(piles,h);
        if(result==answer){
            System.out.println("Test Case Passed");
        }else{
            System.out.println("Test Case Failed");
        }

       // System.out.println(Arrays.stream(piles).max().getAsInt());
    }
}
