public class Practice2 {
    //    Exercise 2:   Has12
//    Create a boolean method called Has12 that takes in an integer array "nums". Given an array of ints, return true if there is a 1 in the array with a 2 somewhere later in the array.
//    For example:
//    has12([1, 3, 2]) → true
//    has12([3, 1, 2]) → true
//    has12([3, 1, 4, 5, 2]) → true
    public boolean Has12(int[] nums) {
        boolean has1 = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1){
                has1 = true;
            }
                if (nums[i] == 2 && has1 == true) {
                return true;
            }

        }return false;
    }
}
