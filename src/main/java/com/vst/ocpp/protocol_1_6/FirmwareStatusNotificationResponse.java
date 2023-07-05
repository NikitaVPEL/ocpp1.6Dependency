package com.vst.ocpp.protocol_1_6;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.Data;

@Data
public class FirmwareStatusNotificationResponse {

	private String messageIdKey;

	public FirmwareStatusNotificationResponse(String messageIdKey) {
		setMessageIdKey(messageIdKey);
	}

	public String toJson() {

		int messageType = 3;
		JsonObject jsonObject = new JsonObject();

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		return jsonString;
	}

}
