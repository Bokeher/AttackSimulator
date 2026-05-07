package org.example.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SHA1AlgorithmTest {

    @Test
    void hash_shouldReturnCorrectSHA1() {
        SHA1Algorithm sha1 = new SHA1Algorithm();

        String result = sha1.hash("hello");

        assertEquals("aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d", result);
    }

    @Test
    void hash_shouldBeDeterministic() {
        SHA1Algorithm sha1 = new SHA1Algorithm();

        String h1 = sha1.hash("test");
        String h2 = sha1.hash("test");

        assertEquals(h1, h2);
    }

    @Test
    void hash_shouldDifferForDifferentInputs() {
        SHA1Algorithm sha1 = new SHA1Algorithm();

        String h1 = sha1.hash("abc");
        String h2 = sha1.hash("def");

        assertNotEquals(h1, h2);
    }

    @Test
    void hash_shouldNotBeEmpty() {
        SHA1Algorithm sha1 = new SHA1Algorithm();

        String result = sha1.hash("anything");

        assertNotNull(result);
        assertFalse(result.isEmpty());
    }
}