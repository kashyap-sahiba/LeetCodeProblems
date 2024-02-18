public class _74_Search_a_2D_Matrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix[0].length-1;
        int row =0;

        while(left<=right && row < matrix.length){
            int mid = (left + right)/2;

            if(target>matrix[row][right]){
                row++;
                left=0;
                right=matrix[0].length-1;
                continue;
            }

            if(target == matrix[row][mid]){
                return true;
            }else if(target<matrix[row][mid]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        boolean answer = true;
        boolean result =searchMatrix(matrix,target);

        if(answer == result){
            System.out.println("Test Case Passed");
        }else{
            System.out.println("Test Case Failed");
        }
    }
}
