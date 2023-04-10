public class Practice5 {
//    Create an integer array method called returnEvenSum that takes in an integer array “nums.”
//    Return the sum of all the even integers in the array.
    public static int returnEvenSum(int [] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] %2 == 0) {
                sum+=nums[i];
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(returnEvenSum(new int[] {2,4,6,5}));
   }
}