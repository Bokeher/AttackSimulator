package org.example.algorithms;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BCryptAlgorithmTest {
    final BCryptAlgorithm bCryptAlgorithm = new BCryptAlgorithm();

    @Test
    void hash_shouldBeVerifiable() {
        String password = "secret123";

        String hash = bCryptAlgorithm.hash(password);

        assertTrue(bCryptAlgorithm.verify(password, hash));
    }

    @Test
    void verify_shouldFailForWrongPassword() {
        String hash = bCryptAlgorithm.hash("secret123");

        assertFalse(bCryptAlgorithm.verify("wrong", hash));
    }

    @Test
    void hash_shouldBeDifferentEachTime() {
        String h1 = bCryptAlgorithm.hash("test");
        String h2 = bCryptAlgorithm.hash("test");

        assertNotEquals(h1, h2);
    }

    @Test
    void hash_shouldNotBeEmpty() {
        String hash = bCryptAlgorithm.hash("test");

        assertNotNull(hash);
        assertTrue(hash.startsWith("$2"));
    }
}