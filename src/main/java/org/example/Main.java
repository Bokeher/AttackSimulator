package org.example;

import org.example.algorithms.Algorithm;
import org.example.attacks.Attack;
import org.example.attacks.BruteForceAttack;
import org.example.attacks.DictionaryAttack;

import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
//        Algorithm algorithm = new MD5Algorithm();

        Algorithm algorithm = text -> text;

        String hash = algorithm.hash("tomek1");

        // --- DICTIONARY ATTACK (resources) ---
        InputStream dictStream = Main.class
                .getClassLoader()
                .getResourceAsStream("dictionary.txt");

        Attack attack = new DictionaryAttack(dictStream);
        Simulation sim = new Simulation(attack, algorithm);

        sim.run(hash);

        Charset charset = Charset.builder()
                .lowercase()
                .digits()
                .build();

        // --- BRUTE FORCE ---
        Attack attack2 = new BruteForceAttack(charset.getChars(), 8);
        Simulation sim2 = new Simulation(attack2, algorithm);

        sim2.run(hash);
    }
}