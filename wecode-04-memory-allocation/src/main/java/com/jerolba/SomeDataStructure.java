package com.jerolba;

class SomeDataStructure {

    private int id;

    public SomeDataStructure(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
	    return "Value: " + id; 
	}
	
}