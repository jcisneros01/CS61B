public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        var deque = new ArrayDeque<Character>();
        char[] chars = word.toCharArray();
        for (char ch: chars) {
            deque.addLast(ch);
        }
        return deque;
    }
}
