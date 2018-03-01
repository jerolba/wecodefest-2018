package com.jerolba;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemoryAllocation {

    public static void main(String[] args) {
        RecordingHelper recordingHelper = new RecordingHelper(true);
        recordingHelper.run();

        SomeRepository repository = new SomeRepository();

        int it = 0;
        while (true) {
            Map<Integer, SomeDataStructure> map = createMapWithInstances(10_000);
            Collection<SomeDataStructure> myAllocSet = map.values();
            for (SomeDataStructure c : myAllocSet) {
                if (!map.containsKey(c.getId())) {
                    System.out.println("This can not happen!");
                }
            }
            for (int i = 0; i < 10; i++) {
                for (SomeDataStructure data : myAllocSet) {
                    if (map.get(data.getId()).toString().length() == 1) {
                        System.out.println("This can not happen!");
                    }
                    if (data.getId() % 10 == 0) {
                        repository.put(data);
                    }
                }
            }
            it++;
            if (it % 100 == 0) {
                System.out.println("Iterations: "+it);
            }
        }
    }

    private static HashMap<Integer, SomeDataStructure> createMapWithInstances(int count) {
        HashMap<Integer, SomeDataStructure> map = new HashMap<>();
        for (int i = 0; i < count; i++) {
            map.put(i, new SomeDataStructure(i));
        }
        return map;
    }
}
