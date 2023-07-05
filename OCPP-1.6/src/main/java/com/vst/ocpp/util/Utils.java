package com.vst.ocpp.util;

public class Utils {
	
	private static final String ERROR_MESSAGE = "Exceeded limit of %s chars";
	
	public static boolean validate(String input, int maxLength) {
		return input != null && input.length() <= maxLength;
	}
	
	public static String createErrorMessage(int valueMaxLength) {
		return String.format(ERROR_MESSAGE, valueMaxLength);
	}
	
	 public static boolean checkEnum(String received, String[] allEnums) {
		    boolean found = false;
		    if (allEnums != null) {
		      for (String singleEnum : allEnums) {
		        if (found = isNullOrEqual(singleEnum, received)) {
		          break;
		        }
		      }
		    }
		    return found;
		  }

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
