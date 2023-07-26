package com.vst.ocpp.testprotocol_1_6;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@Slf4j
public class UpdateFirmwareResponse {

	private String messageIdKey;

	public UpdateFirmwareResponse(String messageIdKey) {
		setMessageIdKey(messageIdKey);

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
	 * use this method to generate json string of {@link UpdateFirmwareResponse}
	 * 
	 * @return string of {@link UpdateFirmwareResponse}
	 */
	public String toJson() {

		int messageType = 3;

		JsonObject jsonObject = new JsonObject();

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		log.debug(jsonString);
		return jsonString;
	}

}
