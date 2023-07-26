package com.vst.ocpp.util;

public final class Utils {
	
	private Utils(){
	}

	private static final String ERROR_MESSAGE = "Exceeded limit of %s chars";

	/**
	 * Validates if the input string is not null and its length is less than or
	 * equal to the specified maximum length.
	 * 
	 * @param input     the input string to validate
	 * @param maxLength the maximum allowed length
	 * @return true if the input is valid, false otherwise
	 */
	public static boolean validate(String input, int maxLength) {
		return input != null && input.length() <= maxLength;
	}

	/**
	 * Creates an error message for exceeding the maximum length.
	 * 
	 * @param valueMaxLength the maximum length allowed for the value
	 * @return the error message with the specified maximum length
	 */
	public static String createErrorMessage(int valueMaxLength) {
		return String.format(ERROR_MESSAGE, valueMaxLength);
	}

	/**
	 * Checks if a given string value is present in the array of enum values.
	 * 
	 * @param received the string value to check
	 * @param allEnums the array of enum values to compare against
	 * @return true if the value is found in the array, false otherwise
	 */
	public static boolean checkEnum(String received, String[] allEnums) {
		boolean found = false;
		if (allEnums != null) {
			for (String singleEnum : allEnums) {
				found = isNullOrEqual(singleEnum, received);
				if (found) {
					break;
				}
			}
		}
		return found;
	}

	/**
	 * Checks if two objects are either both null or equal.
	 * 
	 * @param object1 the first object to compare
	 * @param object2 the second object to compare
	 * @return true if both objects are null or equal, false otherwise
	 */
	private static boolean isNullOrEqual(Object object1, Object object2) {
		boolean nullOrEqual = false;
		if (object1 == null && object2 == null) {
			nullOrEqual = true;
		} else if (object1 != null && object2 != null) {
			nullOrEqual = object1.equals(object2);
		}
		return nullOrEqual;
	}

}
