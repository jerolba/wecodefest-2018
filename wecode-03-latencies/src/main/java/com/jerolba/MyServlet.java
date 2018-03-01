package com.jerolba;

import com.jerolba.Connection.ConnectionFactory;

public class MyServlet {

    private static int MAGIC_NUMBER = 60_000_000;

    private int cont = 0;
    private long totalTime = 0;
    private int id;

    public MyServlet(int id) {
        this.id = id;
    }

    public void processRequest() {
        meterExecution(() -> {
            int result = cpuConsumeTask();
            Connection connection = ConnectionFactory.getConnection();
            connection.executeQuery(id, cont, result);
        });
    }

    private int cpuConsumeTask() {
        int x = 1;
        int y = 1;
        for (int i = 1; i < MAGIC_NUMBER; i++) {
            x += 1;
            y = y % (MAGIC_NUMBER + 3);
            if (x % (MAGIC_NUMBER + 4) == 0 || y == 0) {
                System.out.println("Should not happen, used to avoid code optimization");
            }
        }
        return x + y;
    }

    public int getRequests() {
        return cont;
    }

    public int getId() {
        return id;
    }

    private void meterExecution(Runnable code) {
        long before = System.currentTimeMillis();
        code.run();
        long after = System.currentTimeMillis();
        totalTime = totalTime + (after - before);
        cont++;
    }

    public long getAverageExecutionTime() {
        return totalTime / cont;
    }
}
