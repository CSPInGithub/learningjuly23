package org.hcl.java;

import java.util.Scanner;

public class Marks {

	/*
	 * 1.Write down java code for Students marks calculation.
	 * 
	 * Declare variables for Objective, handson and totalmark.
	 * 
	 * Write the method to calculate the total marks.
	 * 
	 * Provide the input values and calculate the total marks.
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("enter objectiveMarks: ");
		int objectiveMarks = scanner.nextInt();

		System.out.print("enter handsOnMarks: ");
		int handsOnMarks = scanner.nextInt();

		int totalMarks = calculateTotalMarks(objectiveMarks, handsOnMarks);

		System.out.println("Total Marks: " + totalMarks);
		scanner.close();
	}

	private static int calculateTotalMarks(int objectiveMarks, int handsOnMarks) {

		int totalMarks = objectiveMarks + handsOnMarks;
		return totalMarks;
	}

}
