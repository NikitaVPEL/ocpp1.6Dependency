package com.vst.ocpp.testProtocol_1_6;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class GetLocalListVersionResponse {

	private Integer listVersion;
	String messageIdKey;

	public GetLocalListVersionResponse(Integer listVersion, String messageIdKey) {
		setListVersion(listVersion);
		setMessageIdKey(messageIdKey);
	}

	public Integer getListVersion() {
		return listVersion;
	}

	public void setListVersion(Integer listVersion) {
		this.listVersion = listVersion;
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

		jsonObject.addProperty("listVersion", listVersion);

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add(jsonObject);

		return jsonArray.toString();

	}

}
