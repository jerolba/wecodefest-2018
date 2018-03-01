package com.jerolba;

import java.util.HashSet;
import java.util.Set;

public class SomeRepository {

    private Set<SomeDataStructure> info = new HashSet<>();
    
    public void put(SomeDataStructure data) {
        if (!info.contains(data)) {
            info.add(data);
        }
    }
    
}
