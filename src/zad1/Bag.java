package zad1;

public class Bag {

	double maxCapacity,
		taken,sumValue;

	public Bag(double capacity){

		this.maxCapacity = capacity;

	}

	public void put(double itemWeight,double itemValue){

		if(itemWeight + taken <= maxCapacity) {
			taken += itemWeight;
			sumValue+=itemValue;
		}

	}



}
