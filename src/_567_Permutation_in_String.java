import java.util.Arrays;

public class _567_Permutation_in_String {
    public static boolean checkInclusion(String s1, String s2) {
       /* int i =0;
        int j =s1.length()-1;
        char[] s1Arr = s1.toCharArray();
        Arrays.sort(s1Arr);
        s1=  String.copyValueOf(s1Arr);

        while(j<s2.length()){
            String temp = s2.substring(i,j+1);
            char[] tempArr = temp.toCharArray();
            Arrays.sort(tempArr);
            temp = String.copyValueOf(tempArr);

            if(temp.equals(s1)){
                return true;
            }else{
                i++;
                j++;
            }

        }

        return false; */

       /* int i =0;
        int j =s1.length()-1;

        int[] s1Freq = createFrequencyMap(s1);

        while(j<s2.length()){
            String temp = s2.substring(i,j+1);
            int[] tempFreq = createFrequencyMap(temp);

            boolean isEqual = true;

            for(int k=0;k<26;k++){
                if(s1Freq[k]!=tempFreq[k]){
                   isEqual = false;
                }
            }

            if(isEqual){
                return true;
            }else{
                i++;
                j++;
            }

        }

    return false;

    }

    public static int[] createFrequencyMap(String str){

           int[] freqMap = new int[26];

           for(char c : str.toCharArray()){
              freqMap[c-'a']++;

           }
            return freqMap;
    }*/

        //Solution 3 - Neetcode
        int freq1[] = new int[26];
        int n = s1.length();

        for(int i = 0 ; i < n; i++){
            freq1[s1.charAt(i)-'a']++;
        }

        int freq2[] = new int[26];
        int m = s2.length();

        for(int i = 0 ;i<m;i++){
            freq2[s2.charAt(i)-'a']++;

            if(i>=n){
                freq2[s2.charAt(i-n)-'a']--;
            }

            if(Arrays.equals(freq1,freq2)){
                return true;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        String s1 = "arm";
        String s2 = "farmer";

        boolean result = checkInclusion(s1,s2);
        boolean answer = true;

        if(result==answer){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
    }
}
