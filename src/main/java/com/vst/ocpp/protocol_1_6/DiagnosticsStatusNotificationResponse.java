package com.vst.ocpp.protocol_1_6;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.Data;

@Data
public class DiagnosticsStatusNotificationResponse {
	
	private String messageIdKey;

	public DiagnosticsStatusNotificationResponse(String messageIdKey) {
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
