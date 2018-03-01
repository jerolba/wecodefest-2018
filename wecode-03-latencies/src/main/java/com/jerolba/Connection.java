package com.jerolba;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Connection {

    private static final int WORKER_THREADS = 2;
    private static final int SHARED_RESOURCE_TIME = 200;
    private static final int QUERY_EXECUTION_TIME = 400;

    private static Logger LOGGER = LoggerFactory.getLogger(Connection.class);

	private static Connection myInstance = new Connection();

	private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(WORKER_THREADS, WORKER_THREADS, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

	private Connection() {
	}

	public static class ConnectionFactory {

	    public static synchronized Connection getConnection() {
	        try {
	            // Simulate that this takes a little while.
	            Thread.sleep(SHARED_RESOURCE_TIME);
	        } catch (InterruptedException e) {
	            // Don't care.
	        }
	        return myInstance;
	    }

	}


	public synchronized void executeQuery(int id, int cont, int value){
	    Runnable runnable = () -> {
	        LOGGER.info("Executing very complex database operation on servlet {} request {}", id, cont);
            try {
                // Simulate that this takes a little while.
                //Uncomment following line if server does not work or you do not have connection to cloud server
                //Thread.sleep(QUERY_EXECUTION_TIME);
                URL url = new URL("http://localhost:8080/sleep?time="+QUERY_EXECUTION_TIME);
                //Comment following lines if there is no server up
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.getResponseCode();
            } catch (Exception e) {
                e.printStackTrace();
            }
	    };
	    try {
	        Future<?> future = threadPoolExecutor.submit(runnable);
	        future.get();
	    } catch (Exception e) {
            // Don't care.
        }
	}

	public static void shutdown() {
	    threadPoolExecutor.shutdownNow();
	}
}
