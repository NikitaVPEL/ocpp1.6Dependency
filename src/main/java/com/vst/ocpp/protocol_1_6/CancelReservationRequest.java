package com.vst.ocpp.protocol_1_6;

import java.util.Random;
import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class CancelReservationRequest {
	
	Random random = new Random();
	StringBuilder randomStringBuilder = new StringBuilder();
	
	  private Integer reservationId;

	public CancelReservationRequest(Integer reservationId) {
		setReservationId(reservationId);
	}

	public Integer getReservationId() {
		return reservationId;
	}

	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}
	  
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
		return jsonString;
	}
	  

}
