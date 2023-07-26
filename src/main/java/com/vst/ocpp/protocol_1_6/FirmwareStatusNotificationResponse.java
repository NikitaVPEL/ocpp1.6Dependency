package com.vst.ocpp.protocol_1_6;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.testprotocol_1_6.FirmwareStatusNotificationRequest;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Sent by the Central System to the Charge Point in response to an {@link
 * FirmwareStatusNotificationRequest}.
 */
@Data
@NoArgsConstructor
@Slf4j
public class FirmwareStatusNotificationResponse {

	private String messageIdKey;

	public FirmwareStatusNotificationResponse(String messageIdKey) {
		setMessageIdKey(messageIdKey);
	}

	/**
	 * use this method to generate json string of {@link FirmwareStatusNotificationResponse}
	 * 
	 * @return string of {@link FirmwareStatusNotificationResponse}
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
