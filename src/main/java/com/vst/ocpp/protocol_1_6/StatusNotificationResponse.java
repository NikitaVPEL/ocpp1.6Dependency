package com.vst.ocpp.protocol_1_6;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.testprotocol_1_6.StatusNotificationRequest;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Sent by the Central System to the Charge Point in response to a
 * {@link StatusNotificationRequest}.
 *
 * @see StatusNotificationRequest
 */
@Slf4j
@NoArgsConstructor
@Data
public class StatusNotificationResponse {

	private String messageIdKey;

	public StatusNotificationResponse(String messageIdKey) {
		setMessageIdKey(messageIdKey);
	}


	/**
	 * use this method to generate json string
	 * 
	 * @return string of {@link StatusNotificationResponse}
	 */
	public String toJson() {

		int messageType = 3;
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
