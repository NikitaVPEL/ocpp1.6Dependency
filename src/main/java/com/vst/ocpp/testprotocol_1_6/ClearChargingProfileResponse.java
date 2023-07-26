package com.vst.ocpp.testprotocol_1_6;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@Slf4j
public class ClearChargingProfileResponse {

	private ClearChargingProfileStatusEnum status;
	private String messageIdKey;

	/**
	 * Handle required fields.
	 *
	 * @param status the {@link ChargingProfileStatusEnum}, see
	 *               {@link #setStatus(ClearChargingProfileStatusEnum)}.
	 */
	public ClearChargingProfileResponse(ClearChargingProfileStatusEnum status, String messageIdKey) {
		setStatus(status);
		setMessageIdKey(messageIdKey);

	}

	/**
	 * This indicates the success or failure of the change of the charging profile.
	 *
	 * @return the {@link ClearChargingProfileStatusEnum}.
	 */
	public ClearChargingProfileStatusEnum getStatus() {
		return status;
	}

	/**
	 * Required. This indicates the success or failure of the change of the charging
	 * profile.
	 *
	 * @param status the {@link ClearChargingProfileStatusEnum}.
	 */
	public void setStatus(ClearChargingProfileStatusEnum status) {
		this.status = status;
	}

	/**
	 * MessageIdKey indicating whether Charge Point returns the response to same
	 * message id key
	 */
	public String getMessageIdKey() {
		return messageIdKey;
	}

	/**
	 * MessageIdKey indicating whether Charge Point returns the response to same
	 * message id key
	 */
	public void setMessageIdKey(String messageIdKey) {
		this.messageIdKey = messageIdKey;
	}

	/**
	 * use this method to generate json string of {@link ClearChargingProfileResponse}
	 * 
	 * @return string of {@link ClearChargingProfileResponse}
	 */
	public String toJson() {

		int messageType = 3;

		JsonObject jsonObject = new JsonObject();

		jsonObject.addProperty("status", status.toString());

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		log.debug(jsonString);
		return jsonString;	}

}
