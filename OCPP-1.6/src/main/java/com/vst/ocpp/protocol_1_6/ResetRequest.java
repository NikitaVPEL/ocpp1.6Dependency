package com.vst.ocpp.protocol_1_6;

import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ResetRequest {

	private ResetType type;

	public ResetRequest(ResetType type) {
		setType(type);
	}

	public ResetType getType() {
		return type;
	}

	public void setType(ResetType type) {
		this.type = type;
	}

	public String toJson() {

		int messageType = 2;
		String messageIdKey = UUID.randomUUID().toString();

		JsonArray jsonArray = new JsonArray();

		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("type", type.toString());

		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add("Reset");
		jsonArray.add(jsonObject);

		return jsonArray.toString();

	}
}
