package com.vst.ocpp.testprotocol_1_6;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/** return by Charge Point to Central System. */
@NoArgsConstructor
@Slf4j
public class ChangeAvailabilityResponse {

	private AvailabilityStatusEnum status;
	private String messageIdKey;

	  /**
	   * Handle required fields.
	   *
	   * @param status the {@link AvailabilityStatusEnum}, see {@link #setStatus(AvailabilityStatusEnum)}
	   */
	public ChangeAvailabilityResponse(AvailabilityStatusEnum status, String messageIdKey) {
		setStatus(status);
		setMessageIdKey(messageIdKey);

	}

	  /**
	   * This indicates whether the Charge Point is able to perform the availability change.
	   *
	   * @return The {@link AvailabilityStatusEnum} of the connector.
	   */
	public AvailabilityStatusEnum getStatus() {
		return status;
	}

	  /**
	   * Required. This indicates whether the Charge Point is able to perform the availability change.
	   *
	   * @param status the {@link AvailabilityStatusEnum} of connector.
	   */
	public void setStatus(AvailabilityStatusEnum status) {
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
	 * use this method to generate json string of {@link ChangeAvailabilityResponse}
	 * 
	 * @return string of {@link ChangeAvailabilityResponse}
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
