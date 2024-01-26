import java.util.Arrays;

public class _1299_Replace_Elements_with_Greatest_Element_on_Right_Side {

    public static int[] replaceElements(int[] arr) {
        int max=arr[arr.length-1];
        for(int i=arr.length-2;i>=0;i--){
            int curr=arr[i];
            arr[i]=max;
            if(curr>max){
                max=curr;
            }
        }

        arr[arr.length-1]=-1;
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{17,18,5,4,6,1};
        System.out.println(Arrays.toString(replaceElements(arr)));

    }
}
