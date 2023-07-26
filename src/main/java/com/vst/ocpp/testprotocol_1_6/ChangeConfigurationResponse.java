package com.vst.ocpp.testprotocol_1_6;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/** return by Charge Point to Central System. */
@NoArgsConstructor
@Slf4j
public class ChangeConfigurationResponse {

	private ConfigurationStatusEnum status;
	private String messageIdKey;

	/**
	 * Handle required fields.
	 *
	 * @param status the {@link ConfigurationStatusEnum}, see
	 *               {@link #setStatus(ConfigurationStatusEnum)}
	 */
	public ChangeConfigurationResponse(ConfigurationStatusEnum status, String messageIdKey) {
		setStatus(status);
		setMessageIdKey(messageIdKey);

	}

	/**
	 * Returns whether configuration change has been accepted.
	 *
	 * @return String, the {@link ConfigurationStatusEnum}.
	 */
	public ConfigurationStatusEnum getStatus() {
		return status;
	}

	/**
	 * Required. Returns whether configuration change has been accepted.
	 *
	 * @param status the {@link ConfigurationStatusEnum}.
	 */
	public void setStatus(ConfigurationStatusEnum status) {
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
	 * use this method to generate json string of
	 * {@link ChangeConfigurationResponse}
	 * 
	 * @return string of {@link ChangeConfigurationResponse}
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
