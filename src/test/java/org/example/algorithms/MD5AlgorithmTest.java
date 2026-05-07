package org.example.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MD5AlgorithmTest {
    @Test
    void hash_shouldReturnCorrectMD5() {
        MD5Algorithm md5 = new MD5Algorithm();

        String result = md5.hash("hello");

        assertEquals("5d41402abc4b2a76b9719d911017c592", result);
    }

    @Test
    void hash_shouldBeDeterministic() {
        MD5Algorithm md5 = new MD5Algorithm();

        String h1 = md5.hash("test");
        String h2 = md5.hash("test");

        assertEquals(h1, h2);
    }

    @Test
    void hash_shouldDifferForDifferentInputs() {
        MD5Algorithm md5 = new MD5Algorithm();

        String h1 = md5.hash("abc");
        String h2 = md5.hash("def");

        assertNotEquals(h1, h2);
    }
}