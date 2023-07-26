package com.vst.ocpp.testprotocol_1_6;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@Slf4j
public class SetChargingProfileResponse {

	private ChargingProfileStatusEnum status;
	private String messageIdKey;

	/**
	 * Handle required fields.
	 *
	 * @param status the {@link ResetStatus}, see {@link #setStatus(ResetStatus)}
	 */
	public SetChargingProfileResponse(ChargingProfileStatusEnum status, String messageIdKey) {
		setStatus(status);
		setMessageIdKey(messageIdKey);

	}

	/**
	 * This indicates whether the Charge Point is able to perform the reset.
	 *
	 * @return the {@link ResetStatusEnum}.
	 */
	public ChargingProfileStatusEnum getStatus() {
		return status;
	}

	/**
	 * Required. This indicates whether the Charge Point is able to perform the
	 * reset.
	 *
	 * @param status the {@link ResetStatusEnums}.
	 */
	public void setStatus(ChargingProfileStatusEnum status) {
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
	 * use this method to generate json string of {@link ResetStatusEnum}
	 * 
	 * @return string of {@link ResetStatusEnum}
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
		return jsonString;
	}

}
