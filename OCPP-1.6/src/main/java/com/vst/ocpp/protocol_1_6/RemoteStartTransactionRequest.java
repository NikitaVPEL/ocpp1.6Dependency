package com.vst.ocpp.protocol_1_6;

import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.chargingProfile.ChargingProfile;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RemoteStartTransactionRequest {

	private String idTag;
	private Integer connectorId;
	private ChargingProfile chargingProfile;

	public RemoteStartTransactionRequest(String idTag, Integer connectorId, ChargingProfile chargingProfile) {

		this(idTag);
		setConnectorId(connectorId);
		setChargingProfile(chargingProfile);
	}

	public RemoteStartTransactionRequest(String idTag) {
		setIdTag(idTag);
	}

	public String getIdTag() {
		return idTag;
	}

	public void setIdTag(String idTag) {
		this.idTag = idTag;
	}

	public Integer getConnectorId() {
		return connectorId;
	}

	public void setConnectorId(Integer connectorId) {
		this.connectorId = connectorId;
	}

	public JsonObject getChargingProfile() {

		JsonObject chargingProfileObject = new JsonObject();

		// have to decide about this
			chargingProfileObject.addProperty("chargingProfileId", chargingProfile.getChargingProfileId());

		if (chargingProfile.getTransactionId() != null) {
			chargingProfileObject.addProperty("transactionId", chargingProfile.getTransactionId());
		}

			chargingProfileObject.addProperty("stackLevel", chargingProfile.getStackLevel());

			chargingProfileObject.addProperty("chargingProfilePurpose",
					chargingProfile.getChargingProfilePurpose().toString());

			chargingProfileObject.addProperty("chargingProfileKind",
					chargingProfile.getChargingProfileKind().toString());
		

		if (chargingProfile.getRecurrencyKind() != null) {
			chargingProfileObject.addProperty("recurrencyKind", chargingProfile.getRecurrencyKind().toString());
		}

		if (chargingProfile.getValidFrom() != null) {
			chargingProfileObject.addProperty("validFrom", chargingProfile.getValidFrom().toString());
		}

		if (chargingProfile.getValidTo() != null) {
			chargingProfileObject.addProperty("validTo", chargingProfile.getValidTo().toString());
		}

		if (chargingProfile.getChargingSchedule() != null) {
			chargingProfileObject.add("chargingSchedule", chargingProfile.getChargingSchedule());
		}

		return chargingProfileObject;
	}

	public void setChargingProfile(ChargingProfile chargingProfile) {
		this.chargingProfile = chargingProfile;
	}

	public String toJson() {

		int messageType = 2;
		String messageIdKey = UUID.randomUUID().toString();

		JsonObject jsonObject = new JsonObject();

		if (connectorId != null) {
			jsonObject.addProperty("connectorId", connectorId);
		}

		jsonObject.addProperty("idTag", idTag);

		if (chargingProfile != null) {
			jsonObject.add("chargingProfile", getChargingProfile());
		}

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add("RemoteStartTransaction");
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		return jsonString;
	}

}
