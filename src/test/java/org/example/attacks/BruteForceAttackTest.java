package org.example.attacks;

import org.example.algorithms.Algorithm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BruteForceAttackTest {
    @Test
    void crack_shouldFindPassword() {
        char[] charset = "abc123".toCharArray();
        int maxLength = 3;

        BruteForceAttack attack = new BruteForceAttack(charset, maxLength);

        Algorithm algorithm = text -> text;

        String password = "ab";

        String hash = algorithm.hash(password);

        String result = attack.crack(hash, algorithm);

        assertEquals(password, result);
    }

    @Test
    void crack_shouldReturnNull_whenCharsetTooSmall() {
        char[] charset = "xyz".toCharArray();
        BruteForceAttack attack = new BruteForceAttack(charset, 3);

        Algorithm algorithm = text -> text;

        String password = "ab";
        String hash = algorithm.hash(password);

        String result = attack.crack(hash, algorithm);

        assertNull(result);
    }
}