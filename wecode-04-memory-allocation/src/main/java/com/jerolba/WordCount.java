package com.jerolba;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class WordCount {

    public static void main(String[] args) throws IOException, InterruptedException {
        WordCount wordCount = new WordCount();
        long init = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            wordCount.go();
            System.out.println("It " + i);
        }
        long end = System.currentTimeMillis();
        System.out.println((end - init) / 1000 + " seconds");
        Thread.sleep(3600 * 1000);
    }

    private Map<WordLocation, Integer> info = new HashMap<>();

    public void go() throws IOException {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("ElQuijote.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        int cont = 0;
        String line = null;
        while ((line = br.readLine()) != null) {
            String[] words = line.split(" ");
            for (int idx = 0; idx < words.length; idx++) {
                add(cont, words[idx], idx);
            }
            cont++;
        }
    }

    private void add(int line, String word, int idx) {
        WordLocation wl = new WordLocation(line, word);
        int cnt = info.computeIfAbsent(wl, v -> 0);
        info.put(wl, cnt + 1);
    }

    public static class WordLocation {

        private int line;
        private String word;

        public WordLocation(int line, String word) {
            this.line = rnd.nextInt(line + 1);
            this.word = word;
        }

        public int getLine() {
            return line;
        }

        public String getWord() {
            return word;
        }

        @Override
        public String toString() {
            return line + " : " + word;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + line;
            result = prime * result + ((word == null) ? 0 : word.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            WordLocation other = (WordLocation) obj;
            if (line != other.line)
                return false;
            if (word == null) {
                if (other.word != null)
                    return false;
            } else if (!word.equals(other.word))
                return false;
            return true;
        }

    }

    private static Random rnd = new Random(1);
}
