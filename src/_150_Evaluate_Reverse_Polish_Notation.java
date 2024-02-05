import java.util.Stack;
import java.util.regex.Pattern;

public class _150_Evaluate_Reverse_Polish_Notation {

    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack();
        for(String token : tokens){
            if(Pattern.matches("-?\\d+",token)){
                stack.push(token);
            }else{
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int result=1;

                if(token.equals("+")){
                    result=num1+num2;
                }else if(token.equals("-")){
                    result=num2-num1;
                }else if(token.equals("*")){
                    result=num1*num2;
                }else if(token.equals("/")){
                    result=num2/num1;
                }

                stack.push(String.valueOf(result));
            }


        }

        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        String[] tokens = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
        int answer = evalRPN(tokens);

        if(answer ==22) {
            System.out.println("Test Case Passed");
        }else{
            System.out.println("Test Case Failed");
        }

    }
}
