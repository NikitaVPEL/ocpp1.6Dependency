package com.vst.ocpp.testProtocol_1_6;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.exception.InvalidLengthException;
import com.vst.ocpp.util.Utils;

import lombok.NoArgsConstructor;

@NoArgsConstructor
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		if (fileName != null) {
			if (!Utils.validate(fileName, STRING_255_CHAR_MAX_LENGTH)) {
				throw new InvalidLengthException(fileName.length(),
						Utils.createErrorMessage(STRING_255_CHAR_MAX_LENGTH));
			}
		}
		this.fileName = fileName;
	}

	public String getMessageIdKey() {
		return messageIdKey;
	}

	public void setMessageIdKey(String messageIdKey) {
		this.messageIdKey = messageIdKey;
	}

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

		return jsonArray.toString();

	}

}
