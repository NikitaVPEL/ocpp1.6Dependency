package com.vst.ocpp.protocol_1_6;

import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.chargingprofile.ChargingProfile;
import com.vst.ocpp.chargingprofile.ChargingProfilePurposeType;
import com.vst.ocpp.exception.InvalidLengthException;
import com.vst.ocpp.util.Utils;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/** Sent to Charge Point by Central System. */
@NoArgsConstructor
@Slf4j
public class RemoteStartTransactionRequest {

	private String idTag;
	private Integer connectorId;
	private ChargingProfile chargingProfile;

	public RemoteStartTransactionRequest(String idTag, Integer connectorId, ChargingProfile chargingProfile) {

		this(idTag);
		setConnectorId(connectorId);
		setChargingProfile(chargingProfile);
	}

	/**
	 * Handle required fields.
	 *
	 * @param idTag a String with max length 20, see {@link #setIdTag(String)}
	 */
	public RemoteStartTransactionRequest(String idTag) {
		setIdTag(idTag);
	}

	/**
	 * The identifier that Charge Point must use to start a transaction.
	 *
	 * @return an IdToken.
	 */
	public String getIdTag() {
		return idTag;
	}

	/**
	 * Required. The identifier that Charge Point must use to start a transaction.
	 *
	 * @param idTag a String with max length 20
	 */
	public void setIdTag(String idTag) {
		if (!Utils.validate(idTag, 20)) {
			throw new InvalidLengthException(idTag.length(), Utils.createErrorMessage(20));
		}
		this.idTag = idTag;
	}

	/**
	 * Number of the connector on which to start the transaction. connectorId SHALL
	 * be &gt; 0.
	 *
	 * @return Connector.
	 */
	public Integer getConnectorId() {
		return connectorId;
	}

	/**
	 * Optional. Number of the connector on which to start the transaction.
	 * connectorId SHALL be &gt; 0.
	 *
	 * @param connectorId integer, connector
	 */
	public void setConnectorId(Integer connectorId) {
		if (connectorId != null) {
			this.connectorId = connectorId;
		}
	}

	/**
	 * Charging Profile to be used by the Charge Point for the requested
	 * transaction.
	 *
	 * @return the {@link ChargingProfile}.
	 */
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

		chargingProfileObject.addProperty("chargingProfileKind", chargingProfile.getChargingProfileKind().toString());

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

	/**
	 * Optional. Charging Profile to be used by the Charge Point for the requested
	 * transaction.
	 * {@link ChargingProfile#setChargingProfilePurpose(ChargingProfilePurposeType)}
	 * MUST be set to TxProfile.
	 *
	 * @param chargingProfile the {@link ChargingProfile}.
	 */
	public void setChargingProfile(ChargingProfile chargingProfile) {
		if (chargingProfile != null) {
			this.chargingProfile = chargingProfile;
		}	}

	/**
	 * use this method to generate json string of
	 * {@link RemoteStartTransactionRequest}
	 * 
	 * @return string of {@link RemoteStartTransactionRequest}
	 */
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
		log.debug(jsonString);
		return jsonString;
	}

}
