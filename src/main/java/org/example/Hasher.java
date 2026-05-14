package org.example;

import org.example.algorithms.Algorithm;
import org.example.algorithms.BCryptAlgorithm;

import java.security.SecureRandom;
import java.util.Base64;

public class Hasher {

    public enum SaltMode {
        NONE,
        FIXED,
        RANDOM
    }

    private final Algorithm algorithm;
    private final SaltMode saltMode;
    private final String fixedSalt;

    public Hasher(Algorithm algorithm, SaltMode saltMode) {
        this(algorithm, saltMode, "defaultSalt");
    }

    public Hasher(Algorithm algorithm, SaltMode saltMode, String fixedSalt) {
        this.algorithm = algorithm;
        this.saltMode = saltMode;
        this.fixedSalt = fixedSalt;
    }

    public String generateHash(String password) {
        String salt = generateSalt();

        if (algorithm instanceof BCryptAlgorithm bCrypt) {
            return bCrypt.hash(password);
        }

        String input = salt + password;
        return algorithm.hash(input);
    }

    private String generateSalt() {
        return switch (saltMode) {
            case NONE -> "";
            case FIXED -> fixedSalt;
            case RANDOM -> generateRandomSalt(16);
        };
    }

    public static String generateRandomSalt(int length) {
        byte[] salt = new byte[length];
        new SecureRandom().nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }
}