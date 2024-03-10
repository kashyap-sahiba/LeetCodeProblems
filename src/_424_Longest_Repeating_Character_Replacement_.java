public class _424_Longest_Repeating_Character_Replacement_ {
    public static int characterReplacement(String s, int k){
        int[] charCount = new int[26];
        int result = 0;
        int max = 0;
        int i =0;

        for(int j=0;j<s.length();j++){
            charCount[s.charAt(j)-'A']++;
            max=Math.max(max,charCount[s.charAt(j)-'A']);
            if(j-i+1-max>k){
                charCount[s.charAt(i)-'A']--;
                i++;
            }
            result = Math.max(result,j-i+1);
        }

        return result;
    }

    public static void main(String[] args) {
        /*
        * Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.
        * */


        String s = "AABABBA";
        int k =1;
        int answer = 4;
        int result = characterReplacement(s,k);

        if(result==answer){
            System.out.println("Test Case Passed");
        }else{
            System.out.println("Failed!!");
        }
    }
}
