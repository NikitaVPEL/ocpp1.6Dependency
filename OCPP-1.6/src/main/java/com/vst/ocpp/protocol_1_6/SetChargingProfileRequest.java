package com.vst.ocpp.protocol_1_6;

import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.chargingProfile.ChargingProfile;

public class SetChargingProfileRequest {

	private Integer connectorId;
	private ChargingProfile csChargingProfiles;

	public SetChargingProfileRequest(Integer connectorId, ChargingProfile csChargingProfiles) {

		setConnectorId(connectorId);
		setCsChargingProfiles(csChargingProfiles);
	}

	public Integer getConnectorId() {
		return connectorId;
	}

	public void setConnectorId(Integer connectorId) {
		this.connectorId = connectorId;
	}

	public JsonObject getCsChargingProfiles() {

		JsonObject chargingProfileObject = new JsonObject();

		// have to decide about this
		chargingProfileObject.addProperty("chargingProfileId", csChargingProfiles.getChargingProfileId());

		if (csChargingProfiles.getTransactionId() != null) {
			chargingProfileObject.addProperty("transactionId", csChargingProfiles.getTransactionId());
		}

		chargingProfileObject.addProperty("stackLevel", csChargingProfiles.getStackLevel());

		chargingProfileObject.addProperty("chargingProfilePurpose",
				csChargingProfiles.getChargingProfilePurpose().toString());

		chargingProfileObject.addProperty("chargingProfileKind",
				csChargingProfiles.getChargingProfileKind().toString());

		if (csChargingProfiles.getRecurrencyKind() != null) {
			chargingProfileObject.addProperty("recurrencyKind", csChargingProfiles.getRecurrencyKind().toString());
		}

		if (csChargingProfiles.getValidFrom() != null) {
			chargingProfileObject.addProperty("validFrom", csChargingProfiles.getValidFrom().toString());
		}

		if (csChargingProfiles.getValidTo() != null) {
			chargingProfileObject.addProperty("validTo", csChargingProfiles.getValidTo().toString());
		}

		if (csChargingProfiles.getChargingSchedule() != null) {
			chargingProfileObject.add("chargingSchedule", csChargingProfiles.getChargingSchedule());
		}

		return chargingProfileObject;
	}

	public void setCsChargingProfiles(ChargingProfile csChargingProfiles) {
		this.csChargingProfiles = csChargingProfiles;
	}

	public String toJson() {

		int messageType = 2;
		String messageIdKey = UUID.randomUUID().toString();

		JsonObject jsonObject = new JsonObject();

		jsonObject.addProperty("connectorId", connectorId);

		jsonObject.add("csChargingProfiles", getCsChargingProfiles());

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add("SetChargingProfile");
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		return jsonString;
	}
}
