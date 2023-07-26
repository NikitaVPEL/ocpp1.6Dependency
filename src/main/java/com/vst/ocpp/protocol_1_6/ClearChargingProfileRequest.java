package com.vst.ocpp.protocol_1_6;

import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.chargingprofile.ChargingProfilePurposeType;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@Slf4j
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

	/**
	 * The ID of the charging profile to clear.
	 *
	 * @return id.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Optional. The ID of the charging profile to clear.
	 *
	 * @param id integer.
	 */
	public void setId(Integer id) {
		if (id != null) {
			this.id = id;

		}
	}

	/**
	 * Specifies the ID of the connector for which to clear charging profiles.
	 *
	 * @return connectorId.
	 */
	public Integer getConnectorId() {
		return connectorId;
	}

	/**
	 * Optional. Specifies the ID of the connector for which to clear charging
	 * profiles.
	 *
	 * @param connectorId integer. value 0
	 */
	public void setConnectorId(Integer connectorId) {
		if (connectorId != null) {
			this.connectorId = connectorId;
		}
	}

	/**
	 * Specifies the purpose of the charging profiles that will be cleared, if they
	 * meet the other criteria in the request.
	 *
	 * @return the {@link ChargingProfilePurposeType}
	 */
	public ChargingProfilePurposeType getChargingProfilePurpose() {
		return chargingProfilePurpose;
	}

	/**
	 * Optional. Specifies the purpose of the charging profiles that will be
	 * cleared, if they meet the other criteria in the request.
	 *
	 * @param chargingProfilePurpose the {@link ChargingProfilePurposeType}
	 */
	public void setChargingProfilePurpose(ChargingProfilePurposeType chargingProfilePurpose) {
		if (chargingProfilePurpose != null) {

			this.chargingProfilePurpose = chargingProfilePurpose;
		}
	}

	/**
	 * Specifies the stackLevel for which charging profiles will be cleared, if they
	 * meet the other criteria in the request.
	 *
	 * @return stackLevel.
	 */
	public Integer getStackLevel() {
		return stackLevel;
	}

	/**
	 * Optional. Specifies the stackLevel for which charging profiles will be
	 * cleared, if they meet the other criteria in the request.
	 *
	 * @param stackLevel integer. value > 0
	 */
	public void setStackLevel(Integer stackLevel) {
		if (stackLevel != null) {
			this.stackLevel = stackLevel;
		}
	}

	/**
	 * use this method to generate json string of
	 * {@link ClearChargingProfileRequest}
	 * 
	 * @return string of {@link ClearChargingProfileRequest}
	 */
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
		log.debug(jsonString);
		return jsonString;
	}

}
