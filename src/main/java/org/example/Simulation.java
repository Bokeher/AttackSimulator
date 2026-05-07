package org.example;

import org.example.attacks.Attack;
import org.example.algorithms.Algorithm;

public class Simulation {

    private final Attack attack;
    private final Algorithm algorithm;

    public Simulation(Attack attack, Algorithm algorithm) {
        this.attack = attack;
        this.algorithm = algorithm;
    }

    public void run(String hash) {
        long startTime = System.currentTimeMillis();

        try {
            String result = attack.crack(hash, algorithm);

            long endTime = System.currentTimeMillis();

            if (result != null) {
                System.out.println("Password found: " + result);
            } else {
                System.out.println("Password not found.");
            }

            System.out.println("Time: " + (endTime - startTime) + " ms");

        } catch (Exception e) {
            System.out.println("Error during attack: " + e.getMessage());
        }
    }
}
