package com.vst.ocpp.testprotocol_1_6;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.exception.InvalidLengthException;
import com.vst.ocpp.util.Utils;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@Slf4j
public class GetDiagnosticsResponse {

	private static final int STRING_255_CHAR_MAX_LENGTH = 255;

	private String fileName;
	String messageIdKey;

	public GetDiagnosticsResponse(String fileName, String messageIdKey) {
		this(messageIdKey);
		setFileName(fileName);
	}

	public GetDiagnosticsResponse(String messageIdKey) {
		setMessageIdKey(messageIdKey);
	}

	/**
	 * This contains the name of the file with diagnostic information that will be
	 * uploaded. This field is not present when no diagnostic information is
	 * available.
	 *
	 * @return String, file name
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Optional. This contains the name of the file with diagnostic information that
	 * will be uploaded. This field is not present when no diagnostic information is
	 * available.
	 *
	 * @param fileName String, file name
	 */
	public void setFileName(String fileName) {
		if (fileName != null) {
			if (!Utils.validate(fileName, STRING_255_CHAR_MAX_LENGTH)) {
				throw new InvalidLengthException(fileName.length(),
						Utils.createErrorMessage(STRING_255_CHAR_MAX_LENGTH));
			}
			this.fileName = fileName;
		}
	}

	/**
	 * MessageIdKey indicating whether Charge Point returns the response to same
	 * message id key
	 */
	public String getMessageIdKey() {
		return messageIdKey;
	}

	/**
	 * MessageIdKey indicating whether Charge Point returns the response to same
	 * message id key
	 */
	public void setMessageIdKey(String messageIdKey) {
		this.messageIdKey = messageIdKey;
	}

	/**
	 * use this method to generate json string of {@link GetDiagnosticsResponse}
	 * 
	 * @return string of {@link GetDiagnosticsResponse}
	 */
	public String toJson() {

		Integer messageType = 3;

		JsonObject jsonObject = new JsonObject();

		if (fileName != null) {
			jsonObject.addProperty("fileName", fileName);
		}

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		log.debug(jsonString);
		return jsonString;

	}

}
