package com.vst.ocpp.testProtocol_1_6;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ClearCacheResponse {

	private ClearCacheStatusEnum status;
	private String messageIdKey;

	public ClearCacheResponse(ClearCacheStatusEnum status, String messageIdKey) {
		setStatus(status);
		setMessageIdKey(messageIdKey);

	}

	public ClearCacheStatusEnum getStatus() {
		return status;
	}

	public void setStatus(ClearCacheStatusEnum status) {
		this.status = status;
	}

	public String getMessageIdKey() {
		return messageIdKey;
	}

	public void setMessageIdKey(String messageIdKey) {
		this.messageIdKey = messageIdKey;
	}

	public String toJson() {

		int messageType = 3;

		JsonObject jsonObject = new JsonObject();

		jsonObject.addProperty("status", status.toString());

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add(jsonObject);

		return jsonArray.toString();
	}

}
