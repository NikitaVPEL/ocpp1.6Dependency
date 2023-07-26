package com.vst.ocpp.testprotocol_1_6;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@Slf4j
public class UnlockConnectorResponse {

	private UnlockStatusEnum status;
	private String messageIdKey;

	/**
	 * Handle required fields.
	 *
	 * @param status the {@link UnlockStatusEnum}, see
	 *               {@link #setStatus(UnlockStatusEnum)}.
	 */
	public UnlockConnectorResponse(UnlockStatusEnum status, String messageIdKey) {
		setStatus(status);
		setMessageIdKey(messageIdKey);

	}

	/**
	 * This indicates the success or failure of the trigger message request.
	 *
	 * @return the {@link UnlockStatusEnum}.
	 */
	public UnlockStatusEnum getStatus() {
		return status;
	}

	/**
	 * Required. This indicates the success or failure of trigger message request.
	 *
	 * @param status the {@link UnlockStatusEnum}.
	 */
	public void setStatus(UnlockStatusEnum status) {
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
	 * use this method to generate json string of {@link UnlockConnectorResponse}
	 * 
	 * @return string of {@link UnlockConnectorResponse}
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
