public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        var deque = new ArrayDeque<Character>();
        char[] chars = word.toCharArray();
        for (char ch: chars) {
            deque.addLast(ch);
        }
        return deque;
    }

    public boolean isPalindrome(String word) {
        var chars = wordToDeque(word);
        while (chars.size() > 1) {
            var first = chars.removeFirst();
            var last = chars.removeLast();
            if (first != last) {
                return false;
            }
        }

        return true;
    }
}
