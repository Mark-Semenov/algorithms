package lesson3;

public class MainClass {

    public static final int SIZE = 10;

    public static void main(String[] args) {
        reverseMessage();
        Deque<Integer> deque = new DequeImpl<>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            deque.insertLeft(i+1);
            deque.insertRight(10-i);
        }

        System.out.println(deque);
    }


    public static void reverseMessage() {
        String message = "производственный процесс";
        StringBuilder builder = new StringBuilder();
        StackImpl<Character> stack = new StackImpl<>(message.length());
        for (int i = 0; i < message.length(); i++) {
            stack.push(message.charAt(i));
        }

        for (int i = 0; i < stack.size() + i; i++) {
            builder.append(stack.pop());
        }

        System.out.println(message);
        System.out.println(builder);
    }
}
