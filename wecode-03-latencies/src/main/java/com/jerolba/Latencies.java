package com.jerolba;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Latencies {

    private static final int SERVLETS_NUMBER = 10;

    public static void main(String[] args) throws InterruptedException, IOException {
        RecordingHelper recordingHelper = new RecordingHelper(false);
        Thread helperThread = recordingHelper.run();

        List<MyServlet> servlets = new Latencies().launchApplicationServer();

        helperThread.join();
        Connection.shutdown();
        System.out.println("Total number of requests: " + servlets.stream().mapToInt(MyServlet::getRequests).sum());
        System.out.println("Average execution time: "+
                           servlets.stream().mapToLong(MyServlet::getAverageExecutionTime).average().getAsDouble());
    }

    public List<MyServlet> launchApplicationServer() {
        List<MyServlet> servlets = IntStream
                .range(0, SERVLETS_NUMBER)
                .mapToObj(i -> new MyServlet(i))
                .collect(Collectors.toList());

        servlets.stream()
                .map(servlet -> new Thread(() -> {
                    while (true) {
                        servlet.processRequest();
                    }
                }, "Worker Thread " + servlet.getId()))
                .forEach(thread -> {
                    thread.setDaemon(true);
                    thread.start();
                });

        return servlets;
    }

}
