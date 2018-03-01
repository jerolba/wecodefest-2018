package com.jerolba;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Book {

    private static Logger LOGGER = LoggerFactory.getLogger(Book.class);

    private Set<String> map = new LinkedHashSet<>();

    public void readBook(String name) {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(name);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        Iterator<String> lines = br.lines().iterator();

        while (lines.hasNext()) {
            String line = lines.next();
            List<String> split = split(line);
            List<String> withOutSpecialChars = removeSpecialChars(split);
            List<String> lowerCase = toLowerCase(withOutSpecialChars);
            for (String word : lowerCase) {
                addWord(word);
            }
        }
    }

    public List<String> getWords() {
        return new ArrayList<>(map);
    }

    private void addWord(String word) {
        map.add(word);
        LOGGER.trace("Loaded " + map.stream().collect(Collectors.summarizingInt(s -> s.length())) + " words");
        LOGGER.trace("Currently loaded words :" + map);
    }

    private List<String> split(String line) {
        List<String> words = Arrays.asList(line.split(" "));
        LOGGER.trace("Words " + words);
        return words;
    }

    private List<String> removeSpecialChars(List<String> words) {
        List<String> withOutSpecialChars = words.stream().map(w -> removeSpecialChars(w)).collect(Collectors.toList());
        LOGGER.trace("No special chars " + withOutSpecialChars);
        return withOutSpecialChars;
    }

    private List<String> toLowerCase(List<String> words) {
        List<String> lowerCase = words.stream().map(w -> toLowerCase(w)).collect(Collectors.toList());
        LOGGER.trace("Lower case" + lowerCase);
        return lowerCase;
    }

    private static final String CHARS = "-.,:;!¡?¿«»\"()'";
    @SuppressWarnings("serial")
    private List<Character> specialChars = new LinkedList<Character>() {
        {
            for (int i = 0; i < CHARS.length(); i++) {
                add(CHARS.charAt(i));
            }
        }
    };

    private String removeSpecialChars(String word) {
        String str = "";
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!specialChars.contains(c)) {
                str += c;
            }
        }
        return str;
    }

    private String toLowerCase(String word) {
        String str = "";
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            switch (c) {
            case 'A':
                str += 'a';
                break;
            case 'Á':
                str += 'á';
                break;
            case 'B':
                str += 'b';
                break;
            case 'C':
                str += 'c';
                break;
            case 'D':
                str += 'd';
                break;
            case 'E':
                str += 'e';
                break;
            case 'É':
                str += 'é';
                break;
            case 'F':
                str += 'f';
                break;
            case 'G':
                str += 'g';
                break;
            case 'H':
                str += 'h';
                break;
            case 'I':
                str += 'i';
                break;
            case 'Í':
                str += 'í';
                break;
            case 'J':
                str += 'j';
                break;
            case 'K':
                str += 'k';
                break;
            case 'L':
                str += 'l';
                break;
            case 'M':
                str += 'm';
                break;
            case 'N':
                str += 'n';
                break;
            case 'Ñ':
                str += 'ñ';
                break;
            case 'O':
                str += 'o';
                break;
            case 'Ó':
                str += 'ó';
                break;
            case 'P':
                str += 'p';
                break;
            case 'Q':
                str += 'q';
                break;
            case 'R':
                str += 'r';
                break;
            case 'S':
                str += 's';
                break;
            case 'T':
                str += 't';
                break;
            case 'U':
                str += 'u';
                break;
            case 'Ú':
                str += 'ú';
                break;
            case 'V':
                str += 'v';
                break;
            case 'W':
                str += 'w';
                break;
            case 'X':
                str += 'x';
                break;
            case 'Y':
                str += 'y';
                break;
            case 'Z':
                str += 'z';
                break;
            default:
                str += c;
            }
        }
        return str;
    }
}
