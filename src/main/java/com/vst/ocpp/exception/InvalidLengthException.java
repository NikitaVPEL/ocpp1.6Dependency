package com.vst.ocpp.exception;

/** Exception used when validating fields. */
public class InvalidLengthException extends RuntimeException {

	private static final long serialVersionUID = 7252998252271168011L;

	private static final String EXCEPTION_MESSAGE_TEMPLATE = "Validation failed: [%s]. Current Value: [%s]";

	public InvalidLengthException(Object currentFieldValue, String errorMessage) {
		    super(createValidationMessage(currentFieldValue, errorMessage));
		  }

	private static String createValidationMessage(Object fieldValue, String errorMessage) {
		return String.format(EXCEPTION_MESSAGE_TEMPLATE, errorMessage, fieldValue);
	}

}
