package com.facebook.projectUtility;

import java.util.ArrayList;
import java.util.stream.IntStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ListComparator {

	// TO LOG THE MESSAGES ON THE CONSOLE AND LOG FILES BOTH
	public static Logger logger = LogManager.getLogger(ListComparator.class);

	public static void main(String[] args) {
		ArrayList<String> list1 = new ArrayList<>();
		ArrayList<String> list2 = new ArrayList<>();

		// Adding elements to the lists
		list1.add("apple");
		list1.add("banana");
		list1.add("cherry");
		System.out.println("List1: "+list1);

		list2.add("apple");
		list2.add("banana");
		list2.add("cherry");
		System.out.println("List2: "+list2);

		//WAY ONE
		// Call the method to compare lists using a for loop
		ListComparator.ComparisonResult resultForLoop = ListComparator.compareLists(list1, list2);

		// Print the result from the for loop method
		if (resultForLoop.isAllMatch()) {
			System.out.println("All elements match in both lists (for loop).");
		} else {
			System.out.println("Elements do not match in both lists (for loop). Mismatched indices: "
					+ resultForLoop.getMismatchIndices());
		}

		//WAY TWO
//		// Call the method to compare lists using streams
//		ListComparator.ComparisonResult resultStream = ListComparator.compareListsUsingStream(list1, list2);
//
//		// Print the result from the stream method
//		if (resultStream.isAllMatch()) {
//			System.out.println("All elements match in both lists (stream).");
//		} else {
//			System.out.println("Elements do not match in both lists (stream). Mismatched indices: "
//					+ resultStream.getMismatchIndices());
//		}
	}
	
	
	public static class ComparisonResult {
		private final boolean allMatch;
		private final List<Integer> mismatchIndices;

		public ComparisonResult(boolean allMatch, List<Integer> mismatchIndices) {
			this.allMatch = allMatch;
			this.mismatchIndices = mismatchIndices;
		}

		public boolean isAllMatch() {
			return allMatch;
		}

		public List<Integer> getMismatchIndices() {
			return mismatchIndices;
		}
	}

	//WAY ONE
	// Method to compare two lists using a for loop
	public static ComparisonResult compareLists(ArrayList<String> list1, ArrayList<String> list2) {
		System.out.println("Method called: compareLists");
		List<Integer> mismatchIndices = new ArrayList<>();

		// Ensure both lists are of the same size
		if (list1.size() != list2.size()) {
			return new ComparisonResult(false, mismatchIndices);
		}

		// Compare elements and collect mismatched indices
		for (int i = 0; i < list1.size(); i++) {
			if (!list1.get(i).equals(list2.get(i))) {
				mismatchIndices.add(i);
			}
		}

		return new ComparisonResult(mismatchIndices.isEmpty(), mismatchIndices);
	}

//	//WAY TWO
//	// Method to compare two lists using streams
//	public static ComparisonResult compareListsUsingStream(ArrayList<String> list1, ArrayList<String> list2) {
//		List<Integer> mismatchIndices = new ArrayList<>();
//		logger.info("Method called: compareListsUsingStream");
//
//		// Ensure both lists are of the same size
//		if (list1.size() != list2.size()) {
//			return new ComparisonResult(false, mismatchIndices);
//		}
//
//		// Compare elements using IntStream and collect mismatched indices
//		IntStream.range(0, list1.size()).filter(i -> !list1.get(i).equals(list2.get(i))).forEach(mismatchIndices::add);
//
//		return new ComparisonResult(mismatchIndices.isEmpty(), mismatchIndices);
//	}

}

