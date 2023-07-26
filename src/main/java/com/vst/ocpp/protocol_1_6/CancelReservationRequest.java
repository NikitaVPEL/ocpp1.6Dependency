package com.vst.ocpp.protocol_1_6;

import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/** Sent by the Central System to the Charge Point. */
@Slf4j
@NoArgsConstructor
public class CancelReservationRequest {

	private Integer reservationId;

	/**
	 * Handle required fields.
	 *
	 * @param reservationId Integer, id of the reservation, see
	 *                      {@link #setReservationId(Integer)}
	 */
	public CancelReservationRequest(Integer reservationId) {
		setReservationId(reservationId);
	}

	/**
	 * Id of the reservation to cancel.
	 *
	 * @return Integer, id of the reservation.
	 */
	public Integer getReservationId() {
		return reservationId;
	}

	/**
	 * Required. Id of the reservation to cancel.
	 *
	 * @param reservationId Integer, id of the reservation.
	 */
	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}

	/**
	 * use this method to generate json string of CancelReservationRequest
	 * 
	 */
	public String toJson() {

		int messageType = 2;
		String messageIdKey = UUID.randomUUID().toString();
		JsonObject jsonObject = new JsonObject();

		jsonObject.addProperty("reservationId", reservationId);

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add("CancelReservation");
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		log.debug(jsonString);
		return jsonString;
	}

}
