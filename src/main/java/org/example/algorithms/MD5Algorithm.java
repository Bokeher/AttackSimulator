package org.example.algorithms;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Algorithm implements Algorithm {
    @Override
    public String hash(String text) {
        MessageDigest md;

        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        var hash = md.digest(text.getBytes());

        return java.util.HexFormat.of().formatHex(hash);
    }
}
