package com.vst.ocpp.protocol_1_6;

import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.chargingProfile.ChargingProfilePurposeType;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ClearChargingProfileRequest {

	private Integer id;
	private Integer connectorId;
	private ChargingProfilePurposeType chargingProfilePurpose;
	private Integer stackLevel;

	public ClearChargingProfileRequest(Integer id, Integer connectorId,
			ChargingProfilePurposeType chargingProfilePurpose, Integer stackLevel) {
		setId(id);
		setConnectorId(connectorId);
		setChargingProfilePurpose(chargingProfilePurpose);
		setStackLevel(stackLevel);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getConnectorId() {
		return connectorId;
	}

	public void setConnectorId(Integer connectorId) {
		this.connectorId = connectorId;
	}

	public ChargingProfilePurposeType getChargingProfilePurpose() {
		return chargingProfilePurpose;
	}

	public void setChargingProfilePurpose(ChargingProfilePurposeType chargingProfilePurpose) {
		this.chargingProfilePurpose = chargingProfilePurpose;
	}

	public Integer getStackLevel() {
		return stackLevel;
	}

	public void setStackLevel(Integer stackLevel) {
		this.stackLevel = stackLevel;
	}

	public String toJson() {

		int messageType = 2;
		String messageIdKey = UUID.randomUUID().toString();

		JsonObject jsonObject = new JsonObject();

		if (id != null) {
			jsonObject.addProperty("id", id);
		}

		if (connectorId != null) {
			jsonObject.addProperty("connectorId", connectorId);
		}

		if (chargingProfilePurpose != null) {
			jsonObject.addProperty("chargingProfilePurpose", chargingProfilePurpose.toString());
		}

		if (stackLevel != null) {
			jsonObject.addProperty("stackLevel", stackLevel);
		}

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add("ClearChargingProfile");
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		return jsonString;
	}

}
