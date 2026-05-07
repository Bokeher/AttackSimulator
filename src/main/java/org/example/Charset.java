package org.example.attacks;

import java.util.LinkedHashSet;
import java.util.Set;

public class Charset {

    private final char[] chars;

    private Charset(Set<Character> chars) {
        this.chars = new char[chars.size()];

        int i = 0;
        for (Character c : chars) {
            this.chars[i++] = c;
        }
    }

    public char[] getChars() {
        return chars;
    }

    public static Builder builder() {
        return new Builder();
    }

    // ---------------- BUILDER ----------------
    public static class Builder {

        private final Set<Character> chars = new LinkedHashSet<>();

        public Builder lowercase() {
            for (char c = 'a'; c <= 'z'; c++) {
                chars.add(c);
            }
            return this;
        }

        public Builder uppercase() {
            for (char c = 'A'; c <= 'Z'; c++) {
                chars.add(c);
            }
            return this;
        }

        public Builder digits() {
            for (char c = '0'; c <= '9'; c++) {
                chars.add(c);
            }
            return this;
        }

        public Builder symbols() {
            String sym = "!@#$%^&*()-_=+[]{};:'\",.<>/?\\|`~";
            for (char c : sym.toCharArray()) {
                chars.add(c);
            }
            return this;
        }

        public Builder addCustom(String custom) {
            for (char c : custom.toCharArray()) {
                chars.add(c);
            }
            return this;
        }

        public Charset build() {
            return new Charset(chars);
        }
    }
}