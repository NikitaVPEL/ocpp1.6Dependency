package com.vst.ocpp.protocol_1_6;

import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.chargingprofile.ChargingProfile;
import com.vst.ocpp.chargingprofile.ChargingProfilePurposeType;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@Slf4j
public class SetChargingProfileRequest {

	private Integer connectorId;
	private ChargingProfile csChargingProfiles;

	/**
	 * Handle required fields.
	 *
	 * @param connectorId     integer. value &gt; 0, see
	 *                        {@link #setConnectorId(Integer)}
	 * @param chargingProfile the {@link ChargingProfile}, see
	 *                        {@link #setCsChargingProfiles(ChargingProfile)}
	 */
	public SetChargingProfileRequest(Integer connectorId, ChargingProfile csChargingProfiles) {

		setConnectorId(connectorId);
		setCsChargingProfiles(csChargingProfiles);
	}

	/**
	 * This identifies which connector of the Charge Point is used.
	 *
	 * @return connector.
	 */
	public Integer getConnectorId() {
		return connectorId;
	}

	/**
	 * Required. This identifies which connector of the Charge Point is used.
	 *
	 * @param connectorId integer. value &gt; 0
	 */
	public void setConnectorId(Integer connectorId) {
		this.connectorId = connectorId;
	}

	/**
	 * Charging Profile to be used by the Charge Point for the requested
	 * transaction.
	 *
	 * @return the {@link ChargingProfile}.
	 */
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

	/**
	 * Optional. Charging Profile to be used by the Charge Point for the requested
	 * transaction.
	 * {@link ChargingProfile#setChargingProfilePurpose(ChargingProfilePurposeType)}
	 * MUST be set to TxProfile.
	 *
	 * @param csChargingProfiles the {@link ChargingProfile}.
	 */
	public void setCsChargingProfiles(ChargingProfile csChargingProfiles) {
		this.csChargingProfiles = csChargingProfiles;
	}

	/**
	 * use this method to generate json string
	 * 
	 * @return string of {@link SetChargingProfileRequest}
	 */
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
		log.debug(jsonString);
		return jsonString;
	}
}
