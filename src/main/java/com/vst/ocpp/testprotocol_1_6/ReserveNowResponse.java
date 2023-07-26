package com.vst.ocpp.testprotocol_1_6;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.protocol_1_6.ReserveNowRequest;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Sent by the Charge Point to the Central System in response to an
 * {@link ReserveNowRequest}.
 */
@NoArgsConstructor
@Slf4j
public class ReserveNowResponse {

	private ReservationStatusEnum status;
	private String messageIdKey;

	/**
	 * Handle required fields.
	 *
	 * @param status ReservationStatusEnum, status of the reservation, see
	 *               {@link #setStatus(ReservationStatusEnum)}
	 */
	public ReserveNowResponse(ReservationStatusEnum status, String messageIdKey) {
		setStatus(status);
		setMessageIdKey(messageIdKey);

	}

	/**
	 * This indicates the success or failure of the reservation.
	 *
	 * @return ReservationStatusEnum, status of the reservation.
	 */
	public ReservationStatusEnum getStatus() {
		return status;
	}

	/**
	 * Required. This indicates the success or failure of the reservation.
	 *
	 * @param status ReservationStatusEnum, status of the reservation.
	 */
	public void setStatus(ReservationStatusEnum status) {
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
	 * use this method to generate json string of {@link ReserveNowResponse}
	 * 
	 * @return string of {@link ReserveNowResponse}
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
