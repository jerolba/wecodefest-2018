package com.jerolba;

import java.io.IOException;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HotMethods {

    private static Logger LOGGER = LoggerFactory.getLogger(HotMethods.class);

    public static void main(String[] args) throws IOException {
        new RecordingHelper(true).run();

        int i = 0;
        Random rnd = new Random();
        while (true) {
            LOGGER.info("Iteration: " + i++);

            LOGGER.info("Creating first");
            BookAnalizer bookAnalized1 = new BookAnalizer("ElQuijote.txt");
            int module1 = rnd.nextInt(7) + 3;
            bookAnalized1.analize(module1);
            LOGGER.info("Created first");

            LOGGER.info("Creating second");
            BookAnalizer bookAnalized2 = new BookAnalizer("ElQuijote.txt");
            int module2 = rnd.nextInt(7) + 3;
            bookAnalized2.analize(module2);
            LOGGER.info("Created second");

            LOGGER.info("Calculating intersection between {} and {}", module1, module2);
            int intersectionSize = bookAnalized1.countIntersection(bookAnalized2);
            LOGGER.info("Intersection size: " + intersectionSize);
        }
    }

}
