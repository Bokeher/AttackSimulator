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