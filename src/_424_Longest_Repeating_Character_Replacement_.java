public class _424_Longest_Repeating_Character_Replacement_ {
    public int characterReplacement(String s, int k){
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
}
