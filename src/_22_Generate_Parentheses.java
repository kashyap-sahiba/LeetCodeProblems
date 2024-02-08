import java.util.*;

public class _22_Generate_Parentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        backTrack(result,"",0,0,n);
        return result;
    }

    public static void backTrack(List<String> result,String seq,int open,int close,int n){
        if(open == n && close == n){
            result.add(seq);
            return;
        }

        if(open<n)
            backTrack(result,seq+"(",open+1,close,n);
        if(close<open)
            backTrack(result,seq+")",open,close+1,n);
    }

    public static void main(String[] args) {
       int n =3;
       List<String> result = generateParenthesis(n);
       Set<String> answer = new HashSet<>();
       Set<String> generatedAnswer= new HashSet<>();
       answer.addAll(Arrays.asList("((()))","(()())","(())()","()(())","()()()"));
       boolean containsAll = true;
       for(String s : result){
           System.out.println(s);
           generatedAnswer.add(s);
       }

       for(String s : answer){
           if(!generatedAnswer.contains(s)){
               containsAll=false;
           }
       }

       if(containsAll && generatedAnswer.size()==answer.size()){
           System.out.println("Test Case Passed");
       }else{
           System.out.println("TEST CASE FAILED");
       }

    }
}
