public class Practice6 {
    //    //Create a boolean method called foundIntTwice that takes in an integer array “nums” and an integer “value.”
//    //Given the integer array and an integer value, return true if the int value appears two or more times in the array.
//    public static boolean foundIntTwice(int[] nums, int value) {
//        int totalValue = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == value) {
//                totalValue++;
//                if (totalValue>=2) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//    public static void main(String [] args) {
//        System.out.println(foundIntTwice(new int[]{1,2,3,4,5}, 5));
//    }
//}
//Days of Code: Day[5]
//    Exercise 6: Only14
//    Create a boolean method called Only14 that takes in an integer array “nums”. Given an array of ints, return true if every element is a 1 or a 4.
//    only14([1, 4, 1, 4]) → true
//    only14([1, 4, 2, 4]) → false
//    only14([1, 1]) → true
//    public static void main(String[] args) {
//        System.out.println(Only14(new int[]{1,1,4}));
//    }
//
//
//    public static boolean Only14(int [] nums) {
//
//        for (int i=0; i<=nums.length-1; i++) {
//            if (nums[i] != 1 && nums[i] != 4){
//                return false;
//            }
//        }
//    return true;
//    }
//    28
//    Days of Code: Day[7]
//    Exercise 8: No23
//    Create a method of type boolean called No23 that takes in an integer array “nums”. Given an int array length 2, return true if it does not contain a 2 or 3.
//    no23([4, 5]) → true
//    no23([4, 2]) → false
//    no23([3, 5]) → false


//    public static void main(String[] args) {
//        System.out.println(No23(new int[]{1,4}));
//    }
//    public static boolean No23(int[] nums) {
//        for (int i = 0; i <= nums.length - 1; i++) {
//            if (nums[i] == 2 || nums[i] == 3) {
//                return false;
//            }
//        }
//        return true;
//    }
//    Exercise 9: No14
//    Create a boolean method called No14 that takes in an integer array “nums”. Given an array of ints,
//    return true if it contains no 1's and it contains no 4's.
//            no14([7, 2, 3]) → true
//    no14([1, 2, 3, 4]) → false
//    no14([2, 3, 4]) → false
        public static void main(String[] args) {
            System.out.println(No14(new int[] {2,3,5,6}));
}

        public static boolean No14(int [] nums) {
            for (int i = 0 ; i<=nums.length-1; i++) {
                if(nums[i] == 1 || nums[i] == 4) {
                    return false;
                }

            } return true;
        }

}
