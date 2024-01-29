import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _347_Top_K_Frequent_Elements {
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freqMap = new HashMap();
        for(int i : nums){
            freqMap.put(i,freqMap.getOrDefault(i,0)+1);
        }
        List<Integer>[] bucket = new List[nums.length+1];

        for(int key : freqMap.keySet()){
            int frequency = freqMap.get(key);
            if(bucket[frequency]==null){
                bucket[frequency] = new ArrayList<>();
            }

            bucket[frequency].add(key);
        }

        int[] res = new int[k];
        int counter = 0;

        for (int pos = bucket.length - 1; pos >= 0 && counter < k; pos--) {
            if (bucket[pos] != null) {
                for (Integer integer : bucket[pos]) {
                    res[counter++] = integer;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(arr,2)));
    }
}
