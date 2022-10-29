package com.skilldistillery.foodtruck.entities;

public class FoodTruck {
	private static int nextTruckId = 0;

	private String name;
	private int id;
	private String food;
	private int rating;
	
	
	//noArg constructor. We don't increase the nextTruckId as we always want to create trucks with the other constructor.
	public FoodTruck() {
	}
	
	//Contructor used for FoodTruckApp, gets all information and sets the ID
	public FoodTruck (String name, String food, int rating) {
		nextTruckId++;
		this.name = name;
		this.food = food;
		this.rating = rating;
		this.id = nextTruckId;
	}
	
	//Get the current number of trucks
	public int getNextTruckId () {
		return nextTruckId;
	}
	
	//Get the average rating of all trucks given. Rounds to the nearest tenth.
	public double getAverageRating (FoodTruck[] truckArray) {
		double average = 0;
		int sum = 0;
		for (int i = 0; i < nextTruckId; i++) {
			sum += truckArray[i].rating;
		}
		average = ((double) sum) / nextTruckId;
		sum = (int) (average * 10);
		average = ((double) sum) / 10;
		return average;
	}
	
	//Get the first truck in the array with the highest rating. 
	//There is no functionality to show multiple trucks with the highest rating at this time.
	public FoodTruck getHighestRating (FoodTruck[] truckArray) {
		int max = 0;
		int highestIndex = 0;
		for (int i = 0; i < nextTruckId; i++) {
			if (truckArray[i].rating > max) {
				max = truckArray[i].rating;
				highestIndex = i;
			}
		}
		return truckArray[highestIndex];
	}
	
	//toString method to provide all information regarding a given truck.
	public String toString () {
		return "ID: " + this.id + " Name: " + this.name + " Food: " + this.food + " Rating: " + this.rating;
	}
}
