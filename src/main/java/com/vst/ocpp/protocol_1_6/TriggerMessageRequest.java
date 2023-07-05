package com.vst.ocpp.protocol_1_6;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
public class TriggerMessageRequest {

	private Integer connectorId;
	private TriggerMessageRequestType requestedMessage;

	public TriggerMessageRequest(Integer connectorId, TriggerMessageRequestType requestedMessage) {
		setConnectorId(connectorId);
		setRequestedMessage(requestedMessage);
	}

	public Integer getConnectorId() {
		return connectorId;
	}

	public void setConnectorId(Integer connectorId) {
		this.connectorId = connectorId;
	}

	public TriggerMessageRequestType getRequestedMessage() {
		return requestedMessage;
	}

	public void setRequestedMessage(TriggerMessageRequestType requestedMessage) {
		this.requestedMessage = requestedMessage;
	}

	public String toJson() {
		int messageType = 2;
		String messageIdKey = UUID.randomUUID().toString();

		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("connectorId", connectorId);
		jsonObject.addProperty("requestedMessage", requestedMessage.toString());

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add("TriggerMessage");
		jsonArray.add(jsonObject);

		return jsonArray.toString();
	}
}
