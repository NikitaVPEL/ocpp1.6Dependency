package com.vst.ocpp.exception;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
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
	
//	@ExceptionHandler(InvalidLengthExcetion.class)
//	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
//	public Map<String, Object> inValidId(InvalidLengthExcetion ex) {
//		Map<String, Object> errorMap = new HashMap<>();
//		ApiErrorResponse response = new ApiErrorResponse();
//		response.setMessage(ex.getMessage());
//		response.setStatus(HttpStatus.NOT_ACCEPTABLE);
//		response.setStatusCode("406");
//		response.setTimestamp(DateTime.now());
//		errorMap.put("error", response);
//		return errorMap;
//	}


	@ExceptionHandler(InvalidLengthException.class)
	@ResponseStatus(HttpStatus.LENGTH_REQUIRED)
	public Map<String, Object>  handleLengthException(HttpServletRequest req, InvalidLengthException exception) {
		
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
	@ExceptionHandler(InvalidDataException.class)
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	public Map<String, Object>  handleDataException(HttpServletRequest req, InvalidDataException exception) {
		
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

	public static ApiErrorResponse createResponse(String url, HttpStatus status, String message) {
		ApiErrorResponse result = new ApiErrorResponse();

		result.setTimestamp(LocalDateTime.now());
		result.setStatus(status);
		result.setError(status.getReasonPhrase());
		result.setMessage(message);
		result.setPath(url);

		return result;
	}

	@Data
	public static class ApiErrorResponse {
		private LocalDateTime timestamp;
		private HttpStatus status;
		private String error;
		private String message;
		private String path;
	}

}
