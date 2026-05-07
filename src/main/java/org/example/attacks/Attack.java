package org.example.attacks;

import org.example.algorithms.Algorithm;

import java.io.IOException;

public interface Attack {
    String crack(String hash, Algorithm algorithm) throws IOException;
}