package com.jerolba;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaTools {

    private static Logger LOGGER = LoggerFactory.getLogger(JavaTools.class);

    public static void main(String[] args) throws IOException, InterruptedException {
        Thread thread1 = new Thread(() -> {
            LOGGER.info("Creating first");
            Book book = new Book();
            book.readBook("ElQuijote.txt");
            LOGGER.info("Created El Quijote");
        }, "First: El Quijote");
        thread1.start();

        Thread thread2 = new Thread(() -> {
            LOGGER.info("Creating second");
            Book book = new Book();
            book.readBook("DonJuanTenorio.txt");
            LOGGER.info("Created Don Juan Tenorio");
        }, "Second: Don Juan Tenorio");
        thread2.start();
        LOGGER.info("Launched");
        thread1.join();
        thread1.join();
        LOGGER.info("Finish");
    }

}
