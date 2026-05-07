package org.example.algorithms;

import org.mindrot.jbcrypt.BCrypt;

public class BCryptAlgorithm implements Algorithm {
    private final int cost;

    public BCryptAlgorithm(int cost) {
        this.cost = cost;
    }

    public BCryptAlgorithm() {
        cost = 10;
    }

    @Override
    public String hash(String text) {
        String hash = BCrypt.hashpw(text, BCrypt.gensalt());

        return hash;
    }


    public boolean verify(String text, String hash) {
        return BCrypt.checkpw(text, hash);
    }
}
