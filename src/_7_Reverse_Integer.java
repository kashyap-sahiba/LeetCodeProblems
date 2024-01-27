public class _7_Reverse_Integer {
    public static int reverse(int x) {
        long result=0;
        boolean negFlag=false;
        if(x<0){
            negFlag=true;
            x=Math.abs(x);
        }
        int absValue=x;
        while(absValue>0){
            result = result*10 +(absValue%10);
            absValue/=10;
        }

        if(negFlag){
            result = -result;
        }

        if(result>Integer.MAX_VALUE || result <Integer.MIN_VALUE){
            result =0;
        }


        return (int)result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
    }
}
