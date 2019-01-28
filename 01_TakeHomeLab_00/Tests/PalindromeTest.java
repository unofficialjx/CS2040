import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeTest {

    @Test
    public void isPalindrome() {
        String s1 = "kasurin";
        String s2 = "nirusak";
        String word = s1.concat(s2);

        boolean b = Palindrome.isPalindrome(word);

        assertTrue(b);
    }
}