import java.util.HashMap;

public class _128_Longest_Consecutive_Sequence {
    public static int longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean> exploredMap = new HashMap();
        int longestLength=0;

        for(int num:nums){
            exploredMap.put(num,Boolean.FALSE);
        }

        for(int num:nums){
            int currentLength=1;

            int nextNum=num+1;
            while(exploredMap.containsKey(nextNum) && exploredMap.get(nextNum)==false){
                currentLength++;
                exploredMap.put(nextNum,Boolean.TRUE);
                nextNum++;


            }

            int prevNum=num-1;
            while(exploredMap.containsKey(prevNum)&& exploredMap.get(prevNum)==false){
                currentLength++;
                exploredMap.put(prevNum,Boolean.TRUE);
                prevNum--;

            }

            longestLength = Math.max(currentLength,longestLength);

        }

        return longestLength;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100,4,200,1,3,2}));
    }


}
