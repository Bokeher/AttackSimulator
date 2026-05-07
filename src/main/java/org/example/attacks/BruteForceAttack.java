package org.example.attacks;

import org.example.algorithms.Algorithm;

public class BruteForceAttack implements Attack {
    private final char[] charset;
    private final int maxLength;

    public BruteForceAttack(char[] charset, int maxLength) {
        this.charset = charset;
        this.maxLength = maxLength;
    }

    @Override
    public String crack(String hash, Algorithm algorithm) {

        for (int length = 1; length <= maxLength; length++) {
            System.out.println("Sprawdzam o długości: " + length);

            int[] indices = new int[length];
            char[] candidate = new char[length];

            while (true) {
                for (int i = 0; i < length; i++) {
                    candidate[i] = charset[indices[i]];
                }

                String current = new String(candidate);

                if (algorithm.hash(current).equals(hash)) {
                    return current;
                }

                int position = length - 1;

                while (position >= 0) {
                    indices[position]++;

                    if (indices[position] < charset.length) {
                        break;
                    }

                    indices[position] = 0;
                    position--;
                }

                if (position < 0) {
                    break;
                }
            }
        }

        return null;
    }
}