package com.vst.ocpp.protocol_1_6;

import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.exception.InvalidLengthException;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UnlockConnectorRequest {

	private Integer connectorId;

	public UnlockConnectorRequest(Integer connectorId) {
		setConnectorId(connectorId);
	}

	public void setConnectorId(Integer connectorId) {
		if (connectorId == null || connectorId <= 0) {
			throw new InvalidLengthException(connectorId, "connectorId must be > 0");
		}
		this.connectorId= connectorId;
	}

	public Integer getConnectorId() {
		return connectorId;
	}
	
	public String toJson() {
		int messageType = 2;
		String messageIdKey = UUID.randomUUID().toString();

		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("connectorId", connectorId);

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add("UnlockConnector");
		jsonArray.add(jsonObject);

		return jsonArray.toString();
	}
}
