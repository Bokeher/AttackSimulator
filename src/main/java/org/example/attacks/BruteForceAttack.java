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
            System.out.println("Sprawdzam o dlugosci: " + length);

            StringBuilder sb = new StringBuilder();

            int charsetSize = charset.length;
            long max = (long) Math.pow(charsetSize, length);

            for (long i = 0; i < max; i++) {

                sb.setLength(0); // reset buildera

                long value = i;

                for (int pos = 0; pos < length; pos++) {
                    sb.append(charset[(int) (value % charsetSize)]);
                    value /= charsetSize;
                }

                String candidate = sb.reverse().toString(); // poprawna kolejność

                if(i % 2000 == 0) System.out.println(candidate);

                if (algorithm.hash(candidate).equals(hash)) {
                    return candidate;
                }
            }
        }

        return null;
    }
}