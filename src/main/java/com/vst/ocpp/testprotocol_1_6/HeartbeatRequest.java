package com.vst.ocpp.testprotocol_1_6;

import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/** Sent by the Charge Point to the Central System. Request holds no values and is always valid. */
@NoArgsConstructor
@Slf4j
public class HeartbeatRequest {

	/**
	 * use this method to generate json string of {@link HeartbeatRequest}
	 * 
	 * @return string of {@link HeartbeatRequest}
	 */
	public String toJson() {

		int messageType = 2;
		String messageIdKey = UUID.randomUUID().toString();

		JsonObject jsonObject = new JsonObject();

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		log.debug(jsonString);
		return jsonString;
	}

}
