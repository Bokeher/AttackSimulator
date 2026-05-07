package org.example.attacks;

import org.example.algorithms.Algorithm;

import java.io.*;

public class DictionaryAttack implements Attack {
    private final InputStream inputStream;

    public DictionaryAttack(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public String crack(String hash, Algorithm algorithm) throws IOException {
        try (BufferedReader reader =
                     new BufferedReader(new InputStreamReader(inputStream))) {

            String line;

            while ((line = reader.readLine()) != null) {
                if (algorithm.hash(line).equals(hash)) {
                    return line;
                }
            }
        }

        return null;
    }
}