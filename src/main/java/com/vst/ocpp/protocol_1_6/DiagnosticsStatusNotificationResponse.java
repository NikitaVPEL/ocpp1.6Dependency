package com.vst.ocpp.protocol_1_6;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.testprotocol_1_6.DiagnosticsStatusNotificationRequest;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Sent by the Central System to the Charge Point in response to an {@link
 * DiagnosticsStatusNotificationRequest}.
 */
@Slf4j
@Data
public class DiagnosticsStatusNotificationResponse {
	
	private String messageIdKey;

	public DiagnosticsStatusNotificationResponse(String messageIdKey) {
		setMessageIdKey(messageIdKey);
	}

	/**
	 * use this method to generate json string of {@link DiagnosticsStatusNotificationResponse}
	 * 
	 * @return string of {@link DiagnosticsStatusNotificationResponse}
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
