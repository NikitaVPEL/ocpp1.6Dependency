package com.vst.ocpp.exception;

/** Exception used when validating fields. */
public class InvalidDataException extends RuntimeException {

	private static final long serialVersionUID = 7252998252271168011L;

	private static final String EXCEPTION_MESSAGE_TEMPLATE = "Validation failed due to - Reason: { %s }. Current Value: [%s]";

	public InvalidDataException(Object currentFieldValue, String errorMessage) {
		    super(createValidationMessage(currentFieldValue, errorMessage));
		  }

	private static String createValidationMessage(Object fieldValue, String errorMessage) {
		return String.format(EXCEPTION_MESSAGE_TEMPLATE, errorMessage, fieldValue);
	}

}
