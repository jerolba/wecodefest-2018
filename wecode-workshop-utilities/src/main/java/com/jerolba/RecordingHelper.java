package com.jerolba;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RecordingHelper {

    private static final String RECORDING = "-XX:StartFlightRecording=";

    private Integer delay;
    private Integer duration;
    private boolean forceExit;

    public RecordingHelper(boolean forceExit) {
        this.forceExit = forceExit;
        RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
        List<String> arguments = runtimeMxBean.getInputArguments();
        Optional<String> recordingParam = arguments.stream().filter(s -> s.startsWith(RECORDING)).findFirst();
        if (recordingParam.isPresent()) {
            String recording = recordingParam.get().substring(RECORDING.length());
            String[] params = recording.split(",");
            Map<String, String> paramMap = Stream.of(params).map(p -> p.split("="))
                    .collect(Collectors.toMap(pv -> pv[0], pv -> pv[1]));
            this.delay = parseWithOutS(paramMap.get("delay"), 0);
            this.duration = parseWithOutS(paramMap.get("duration"), 60);
        }
    }

    private Integer parseWithOutS(String value, Integer defaultValue) {
        if (value != null) {
            return Integer.parseInt(value.substring(0, value.length() - 1));
        }
        return defaultValue;
    }

    public Thread run() {
        if (delay != null && duration != null) {
            Thread thread = new Thread(() -> {
                try {
                    System.out.println("Flight recorder timed execution");
                    System.out.println("Delay time start: " + delay);
                    Thread.sleep(delay * 1000);
                    System.out.println("Delay time end, starting recording: " + duration);
                    Thread.sleep(duration * 1000);
                    System.out.println("Recording time finished");
                    Thread.sleep(1 * 1000);
                    if (forceExit) {
                        System.exit(0);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "Instructions Thread");
            thread.start();
            return thread;
        } else {
            System.out.println("Infinite loop execution, press enter to stop execution.");
            Thread thread = new Thread(() -> {
                try {
                    System.in.read();
                    if (forceExit) {
                        System.exit(0);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
            return thread;
        }
    }

}
