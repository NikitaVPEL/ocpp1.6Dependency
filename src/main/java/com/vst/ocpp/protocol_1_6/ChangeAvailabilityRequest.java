package com.vst.ocpp.protocol_1_6;

import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ChangeAvailabilityRequest {

	private Integer connectorId = -1;
	private AvailabilityType type;

	public ChangeAvailabilityRequest(Integer connectorId, AvailabilityType type) {
		setConnectorId(connectorId);
		setType(type);
	}

	public Integer getConnectorId() {
		return connectorId;
	}

	public void setConnectorId(Integer connectorId) {
		this.connectorId = connectorId;
	}

	public AvailabilityType getType() {
		return type;
	}

	public void setType(AvailabilityType type) {
		this.type = type;
	}
	
	public String toJson() {

		int messageType = 2;
		String messageIdKey = UUID.randomUUID().toString();

		JsonObject jsonObject = new JsonObject();

		jsonObject.addProperty("connectorId", connectorId);
		jsonObject.addProperty("type", type.toString());

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add("ChangeAvailability");
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		return jsonString;
	}

}
