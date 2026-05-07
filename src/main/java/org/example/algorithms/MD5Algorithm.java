package org.example.algorithms;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Algorithm implements Algorithm {
    private final MessageDigest md;

    public MD5Algorithm() {
        try {
            this.md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String hash(String text) {
        md.reset();

        byte[] hash = md.digest(text.getBytes(StandardCharsets.UTF_8));

        return java.util.HexFormat.of().formatHex(hash);
    }
}