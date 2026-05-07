package org.example.attacks;

import org.example.algorithms.Algorithm;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class DictionaryAttackTest {

    @Test
    void shouldFindPasswordInDictionary() throws IOException {
        // given
        File tempFile = File.createTempFile("dict", ".txt");
        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write("hello\n");
            writer.write("password\n");
            writer.write("admin\n");
        }

        InputStream is = new FileInputStream(tempFile);

        Algorithm algorithm = input -> input;

        DictionaryAttack attack = new DictionaryAttack(is);

        // when
        String result = attack.crack("password", algorithm);

        // then
        assertEquals("password", result);
    }

    @Test
    void shouldReturnNullWhenPasswordNotFound() throws IOException {
        // given
        File tempFile = File.createTempFile("dict", ".txt");
        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write("hello\n");
            writer.write("admin\n");
        }

        InputStream is = new FileInputStream(tempFile);

        Algorithm algorithm = input -> input;

        DictionaryAttack attack = new DictionaryAttack(is);

        // when
        String result = attack.crack("password", algorithm);

        // then
        assertNull(result);
    }
}