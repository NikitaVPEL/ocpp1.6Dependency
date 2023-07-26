package com.vst.ocpp.protocol_1_6;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@NoArgsConstructor
@Slf4j
public class MeterValuesResponse {

	private String messageIdKey;

	public MeterValuesResponse(String messageIdKey) {
		setMessageIdKey(messageIdKey);
	}

	/**
	 * use this method to generate json string of {@link MeterValuesResponse}
	 * 
	 * @return string of {@link MeterValuesResponse}
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
