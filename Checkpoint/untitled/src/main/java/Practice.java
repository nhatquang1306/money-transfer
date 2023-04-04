import java.sql.Array;
import java.util.Arrays;

public class Practice {
    public int[] SwapEnds(int[] nums) { //Make method for integer array SwapEnds, pass it int array nums
        int firstNumber = nums[0]; // variable created to hold first number in array
        int lastNumber = nums[nums.length-1]; //variable created to hold last number in array
        int[] newArray = new int[nums.length]; //new array to hold our new swapped value array
        for (int i=0; i< nums.length; i++) { //for loop to populate new array
            if (i==0) { // if it's in the first array position
                newArray[i] = lastNumber; // then first array position is equal to the last array position
            } else if (i== nums.length-1) { //otherwise if it's the final array position
                newArray[i] = firstNumber; // you set the final position equal to the first number of the original array
            } else { //if all else occurs then populate the new array with the remaining numbers
                newArray[i] = nums[i];
            }
        }
        System.out.println(Arrays.toString(newArray)); //Prints out new array
        return newArray; // return the newly populated array
    }
    public static void main(String[] args) {
        int[] nums = new int []{1,2,3,4,5};//testing whether or not the first and last array values are swapped
        Practice practice = new Practice();
        practice.SwapEnds(nums);
    }
}

