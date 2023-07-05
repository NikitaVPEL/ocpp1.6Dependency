package com.vst.ocpp.protocol_1_6;

import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ClearCacheRequest {

	
	public String toJson() {

		int messageType = 2;
		String messageIdKey = UUID.randomUUID().toString();

		JsonObject jsonObject = new JsonObject();
		
		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add("ClearCache");
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		return jsonString;
	}
}
