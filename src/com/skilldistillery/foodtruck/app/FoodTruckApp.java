package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {

	public static void main(String[] args) {
		
		//Create the objects needed for the application to run. We are limiting the array to 5 since that is the max allowed trucks.
		//We create the objects in main since we only need each object once.
		FoodTruck[] truckArray = new FoodTruck[5];
		FoodTruckApp app = new FoodTruckApp();
		FoodTruck len = new FoodTruck();
		Scanner sc = new Scanner(System.in);
		
		//Run the application using the given objects.
		app.runProgram(truckArray, len, sc);
		
		sc.close();
	}

	// Creates food trucks as long as the user wants. Uses while loops to ensure valid inputs.
	private void createFoodTrucks(Scanner sc, FoodTruck[] truckArray) {
		int i;
		int rating = 0;
		String name = "";
		String food = "";

		for (i = 0; i < 5; i++) {
			while (true) {
				System.out.println("Enter a food truck's name, or enter [quit] to move on:");
				name = sc.nextLine();
				if (name.equals("quit")) {
					return;
				} else if (name.equals("")) {
					System.out.println("Invalid name.");
				} else {
					break;
				}
			}
			while (true) {
				System.out.println("Enter the food truck's main food type:");
				food = sc.nextLine();
				if (food.equals("")) {
					System.out.println("Invalid name.");
				} else {
					break;
				}
			}
			while (true) {
				System.out.println("Enter the food truck's rating from 1 to 5:");
				rating = sc.nextInt();
				sc.nextLine();
				if (rating < 1 || rating > 5) {
					System.out.println("Invalid Rating");
				} else {
					break;
				}
			}
			truckArray[i] = new FoodTruck(name, food, rating);

		}
	}

	// Prints the menu.
	private void printMenu() {
		System.out.println("***************************");
		System.out.println("* 1. List all food trucks *");
		System.out.println("* 2. See average rating   *");
		System.out.println("* 3. See highest rating   *");
		System.out.println("* 4. Quit the program     *");
		System.out.println("***************************");
	}

	// Main program method, runs the program.
	private void runProgram(FoodTruck[] truckArray, FoodTruck len, Scanner sc) {
		boolean goAgain = true;
		createFoodTrucks(sc, truckArray);
		// Do we want to keep going?
		while (goAgain) {
			printMenu();
			int response = sc.nextInt();
			if (response < 1 || response > 4) {
				System.out.println("Enter a valid number from the menu.");
				continue;
			}
			// What is our response?
			switch (response) {
			case 1:
				System.out.println("These are the food trucks entered: ");
				for (int i = 0; i < len.getNextTruckId(); i++) {
					if (truckArray[i] != null) {
						System.out.println(truckArray[i]);
					}
				}
				break;
			case 2:
				if (len.getNextTruckId() == 0) {
					System.out.println("No Food Trucks provided.");
					break;
				}
				double average = len.getAverageRating(truckArray);
				System.out.println("The average rating is " + average);
				break;
			case 3:
				if (len.getNextTruckId() == 0) {
					System.out.println("No Food Trucks provided.");
					break;
				}
				System.out.println("The highest rating is: \n" + len.getHighestRating(truckArray));
				break;
			case 4:
				System.out.println("Goodbye!");
				goAgain = false;
				break;
			}
		}
	}
}
