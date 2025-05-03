

import java.util.*;

public class QueueZ {
    static class Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() {
            return s1.isEmpty() && s2.isEmpty();
        }
        
        public static void add(int data) {
          //Simply push to s1 without moving elements, unless nexessary
          s1.push(data);
        }
        public static int remove() {
            if(isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }
            
            // if s2 is empty, move all elements from s1 to s2
            if(s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }

            // Pop from s2, which contains the oldest elements(FIFO)
            return s2.pop();
        }

        public static int peek() {
            if(isEmpty()) {
                System.out.println(("Empty Queue"));
                return -1;
            }

            // If s2 is empty, move elements from s1 to s2
            if(s2.isEmpty()) {
                while(!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }

            //Peek at the front of the queue, which is the top of s2

            return s2.peek();
        }
    }
  
    public static void main(String args[]) {
        // Queue q = new Queue();
        // Queue<Integer> q = new LinkedList<>();

        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }

}