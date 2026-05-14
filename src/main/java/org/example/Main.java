package org.example;

import org.example.algorithms.Algorithm;
import org.example.algorithms.BCryptAlgorithm;
import org.example.algorithms.MD5Algorithm;
import org.example.algorithms.SHA1Algorithm;
import org.example.attacks.Attack;
import org.example.attacks.BruteForceAttack;
import org.example.attacks.DictionaryAttack;

import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        compareCharsets(text -> text);
        compareCharsets(new MD5Algorithm());

        compareAlgorithms();

    }

    static void compareCharsets(Algorithm algorithm) {
        String password = new Hasher(algorithm, Hasher.SaltMode.NONE)
                .generateHash("javaa");

        // 1. lowercase only (baseline)
        Charset c1 = new Charset.Builder().lowercase().build();
        System.out.println("\n=== TEST 1: lowercase only | charset size = " + c1.getChars().length + " ===");

        new Simulation(
                new BruteForceAttack(c1.getChars(), 8),
                algorithm
        ).run(password);

        // 2. lowercase + digits
        Charset c2 = new Charset.Builder().lowercase().digits().build();
        System.out.println("\n=== TEST 2: lowercase + digits | charset size = " + c2.getChars().length + " ===");

        new Simulation(
                new BruteForceAttack(c2.getChars(), 8),
                algorithm
        ).run(password);

        // 3. uppercase + lowercase
        Charset c3 = new Charset.Builder().lowercase().uppercase().build();
        System.out.println("\n=== TEST 3: lowercase + uppercase | charset size = " + c3.getChars().length + " ===");

        new Simulation(
                new BruteForceAttack(c3.getChars(), 8),
                algorithm
        ).run(password);

        // 4. full alphanumeric
        Charset c4 = new Charset.Builder().lowercase().uppercase().digits().build();
        System.out.println("\n=== TEST 4: lowercase + uppercase + digits | charset size = " + c4.getChars().length + " ===");

        new Simulation(
                new BruteForceAttack(c4.getChars(), 8),
                algorithm
        ).run(password);

        // 5. full + symbols
        Charset c5 = new Charset.Builder().lowercase().uppercase().digits().symbols().build();
        System.out.println("\n=== TEST 5: full + symbols | charset size = " + c5.getChars().length + " ===");

        new Simulation(
                new BruteForceAttack(c5.getChars(), 8),
                algorithm
        ).run(password);
    }

    static void compareAlgorithms() {

    }

    static void compareBCryptCost() {

    }

    static void comparePasswordLength() {

    }

    static void compareBruteAndDictionary() {

    }


}