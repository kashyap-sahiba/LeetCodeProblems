import java.util.*;

public class _49_Group_Anagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap();

        for(String word : strs){
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            if(!res.containsKey(sortedWord)){
                res.put(sortedWord,new ArrayList<>());
            }

            res.get(sortedWord).add(word);
        }

        return new ArrayList<>(res.values());

    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs).toString());
    }
}
