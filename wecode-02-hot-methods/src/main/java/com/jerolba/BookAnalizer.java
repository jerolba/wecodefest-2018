package com.jerolba;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class BookAnalizer {

    private final Collection<String> filteredWords = new LinkedList<>();
    private final Book book = new Book();

    public BookAnalizer(String name) {
        book.readBook(name);
    }

    public void analize(int seed) {
        List<String> words = book.getWords();
        for (int i = 1; i < words.size(); i++) {
            if ((i % seed) != 0) {
                filteredWords.add(words.get(i));
            }
        }
    }

    public int countIntersection(BookAnalizer other) {
        int count = 0;
        for (String i : filteredWords) {
            if (other.filteredWords.contains(i)) {
                count++;
            }
        }
        return count;
    }

}
