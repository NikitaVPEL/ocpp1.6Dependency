package com.vst.ocpp.testprotocol_1_6;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.protocol_1_6.AuthorizeResponse;
import com.vst.ocpp.protocol_1_6.CancelReservationRequest;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Sent by the Charge Point to the Central System in response to an
 * {@link CancelReservationRequest}.
 */
@Slf4j
@NoArgsConstructor
public class CancelReservationResponse {

	private CancelReservationStatusEnum status;
	private String messageIdKey;

	/**
	 * Handle required fields.
	 *
	 * @param status CancelReservationStatus, status of the request, see
	 *               {@link #setStatus(CancelReservationStatusEnum)}
	 */
	public CancelReservationResponse(CancelReservationStatusEnum status, String messageIdKey) {
		setStatus(status);
		setMessageIdKey(messageIdKey);

	}

	/**
	 * This indicates the success or failure of the cancelling of a reservation by
	 * Central System.
	 *
	 * @return CancelReservationStatusEnum, status of the request.
	 */
	public CancelReservationStatusEnum getStatus() {
		return status;
	}

	/**
	 * Required. This indicates the success or failure of the cancelling of a
	 * reservation by Central System.
	 *
	 * @param status CancelReservationStatusEnum, status of the request.
	 */
	public void setStatus(CancelReservationStatusEnum status) {
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
	 * use this method to generate json string of {@link AuthorizeResponse}
	 * 
	 * @return string of {@link CancelReservationResponse}
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
