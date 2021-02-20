import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void isNotPalindrome() {
        var strings = List.of("horse", "rancor", "aaaaab");
        for (String str: strings) {
            assertFalse(palindrome.isPalindrome(str));
        }
    }

    @Test
    public void isPalindrome() {
        var strings = List.of("a", "racecar", "noon", "");
        for (String str: strings) {
            assertTrue(palindrome.isPalindrome(str));
        }
    }

    @Test
    public void isNotPalindromeOverloaded() {
        var strings = List.of("horse", "rancor", "aaaaab");
        for (String str: strings) {
            assertFalse(palindrome.isPalindrome(str, new OffByOne()));
        }
    }

    @Test
    public void isPalindromeOverloaded() {
        var strings = List.of("a", "flake", "");
        for (String str: strings) {
            assertTrue(palindrome.isPalindrome(str, new OffByOne()));
        }
    }
}
