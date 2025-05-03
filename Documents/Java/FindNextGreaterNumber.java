
import java.util.Arrays;
import java.util.Stack;

public class FindNextGreaterNumber {
    public static int[] FindNextGreater(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            //Pop elements from stack that are smaller or equal 
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

        // if stack is empty, no greater element to right
        //result[i] = stack.isEmpty() ? -1 : stack.peek();   
        if(stack.isEmpty()) {
            result[i] = -1;
        } else {
            result[i] = stack.peek();
        }

        // Push current element to stack 
        stack.push(arr[i]);
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] input = {6, 8, 0, 1, 3};
        int[] output = FindNextGreater(input);
        System.out.println("Next Greater Elemenets : " + Arrays.toString(output));
    }
}