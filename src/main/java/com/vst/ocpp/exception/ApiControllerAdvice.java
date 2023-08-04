package com.vst.ocpp.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class ApiControllerAdvice {

	String url;
	HttpStatus status;

	/**
	 * Exception handler for InvalidLengthException. It handles the exception and
	 * generates an error response with appropriate status and message.
	 * 
	 * @param req       the HttpServletRequest object representing the current
	 *                  request
	 * @param exception the InvalidLengthException that was thrown
	 * @return a Map containing the error response
	 */
	@ExceptionHandler(InvalidLengthException.class)
	@ResponseStatus(HttpStatus.LENGTH_REQUIRED)
	public Map<String, Object> handleLengthException(HttpServletRequest req, InvalidLengthException exception) {

		Map<String, Object> errorMap = new HashMap<>();
		url = req.getRequestURL().toString();
		String ex = exception.getLocalizedMessage();
		status = HttpStatus.LENGTH_REQUIRED;

		ApiErrorResponse response = new ApiErrorResponse();
		response.setMessage(exception.getMessage());
		response.setStatus(HttpStatus.LENGTH_REQUIRED);
		response.setPath(url);
		response.setTimestamp(LocalDateTime.now());
		response.setError(status.getReasonPhrase());
		errorMap.put("error", response);
		log.error("Request: {} raised following exception. Exception: {}", url, ex);
		return errorMap;

	}

	/**
	 * Exception handler for InvalidDataException. It handles the exception and
	 * generates an error response with appropriate status and message.
	 * 
	 * @param req       the HttpServletRequest object representing the current
	 *                  request
	 * @param exception the InvalidDataException that was thrown
	 * @return a Map containing the error response
	 */
	@ExceptionHandler(InvalidDataException.class)
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	public Map<String, Object> handleDataException(HttpServletRequest req, InvalidDataException exception) {

		Map<String, Object> errorMap = new HashMap<>();
		url = req.getRequestURL().toString();
		String ex = exception.getLocalizedMessage();
		status = HttpStatus.NOT_ACCEPTABLE;

		ApiErrorResponse response = new ApiErrorResponse();
		response.setMessage(exception.getMessage());
		response.setStatus(HttpStatus.NOT_ACCEPTABLE);
		response.setPath(url);
		response.setTimestamp(LocalDateTime.now());
		response.setError(status.getReasonPhrase());
		errorMap.put("error", response);
		log.error("Request: {} raised following exception. Exception: {}", url, ex);
		return errorMap;

	}

	/**
	 * Utility method to create an ApiErrorResponse object with the given
	 * parameters.
	 * 
	 * @param url     the request URL
	 * @param status  the HTTP status
	 * @param message the error message
	 * @return an instance of ApiErrorResponse with the specified properties
	 */
	public static ApiErrorResponse createResponse(String url, HttpStatus status, String message) {
		ApiErrorResponse result = new ApiErrorResponse();

		result.setTimestamp(LocalDateTime.now());
		result.setStatus(status);
		result.setError(status.getReasonPhrase());
		result.setMessage(message);
		result.setPath(url);

		return result;
	}

	/**
	 * Inner class representing the structure of the error response. It contains
	 * properties such as timestamp, status, error, message, and path.
	 */
	@Data
	public static class ApiErrorResponse {
		private LocalDateTime timestamp;
		private HttpStatus status;
		private String error;
		private String message;
		private String path;
	}

}
