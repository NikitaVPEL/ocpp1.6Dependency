package com.vst.ocpp.protocol_1_6;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DataTransferResponse {

	private DataTransferStatus status;
	private String data;
	private String messageIdKey;

	public DataTransferResponse(DataTransferStatus status, String messageIdKey) {
		setStatus(status);
		setMessageIdKey(messageIdKey);
	}

	public DataTransferResponse(DataTransferStatus status, String data, String messageIdKey) {
		this(status, messageIdKey);
		setData(data);
	}

	public DataTransferStatus getStatus() {
		return status;
	}

	public void setStatus(DataTransferStatus status) {
		this.status = status;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
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
		
		if (data!=null) {
			jsonObject.addProperty("data", data);
		}

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		return jsonString;
	}

}
