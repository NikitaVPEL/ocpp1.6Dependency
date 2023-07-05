package com.vst.ocpp.protocol_1_6;

import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.exception.InvalidLengthException;
import com.vst.ocpp.util.Utils;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class GetConfigurationRequest {

	Utils utils = new Utils();

	private static final int KEY_MAX_LENGTH = 50;

	private String[] key;

	public GetConfigurationRequest(String[] key) {
		setKey(key);
	}

	public String[] getKey() {
		return key;
	}

	public JsonArray setKey(String[] key) {

		validateKeys(key);
		this.key = key;

		JsonArray keyArray = new JsonArray();
		for (int i = 0; i < key.length; i++) {
			String keyString = key[i];

			if (keyString != null) {
				keyArray.add(keyString);
			}
		}
		return keyArray;

	}

	private void validateKeys(String[] key) {
		for (String keyString : key) {
			if (!utils.validate(keyString, KEY_MAX_LENGTH)) {
				throw new InvalidLengthException(keyString.length(), utils.createErrorMessage(KEY_MAX_LENGTH));
			}
		}
		
		
	}

	public String toJson() {

		int messageType = 2;
		String messageIdKey = UUID.randomUUID().toString();

		JsonObject jsonObject = new JsonObject();

		jsonObject.add("key", setKey(key));

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add("GetConfiguration");
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		return jsonString;
	}

}
