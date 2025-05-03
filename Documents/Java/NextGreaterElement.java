

import java.util.Stack;
import java.util.Arrays;


// using stack traverse from right to left 
public class NextGreaterElement {
    public static int[] nextGreater(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    Stack<Integer> stack = new Stack<>(); 

    for (int i = n -1; i >= 0; i--) {

        //remove all smaller elements from the stack
        while (!stack.isEmpty() && stack.peek() <= nums[i]) {
            stack.pop();
        }

        // if stack is empty, there is no greater element
        result[i] = stack.isEmpty() ? -1 : stack.peek();

        // push this element onto the stack
        stack.push(nums[i]);
    }
      return result;

    }

    public static void main(String[] args) {
        int[] nums = {6,8,0,1,3};
        int[] output = nextGreater(nums);
        System.out.println("Next Greater Elements : " + Arrays.toString(output));
    }
}