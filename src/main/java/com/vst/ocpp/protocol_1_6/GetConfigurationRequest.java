package com.vst.ocpp.protocol_1_6;

import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.exception.InvalidLengthException;
import com.vst.ocpp.util.Utils;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/** Sent by the the Central System to the Charge Point. */
@NoArgsConstructor
@Slf4j
public class GetConfigurationRequest {

	private static final int KEY_MAX_LENGTH = 50;

	private String[] key;

	public GetConfigurationRequest(String[] key) {
		setKey(key);
	}

	 /**
	   * List of keys for which the configuration value is requested.
	   *
	   * @return Array of key names.
	   */
	public String[] getKey() {
		return key;
	}

	  /**
	   * Optional. List of keys for which the configuration value is requested.
	   *
	   * @param key Array of Strings, max 50 characters each, case insensitive.
	   */
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
			if (!Utils.validate(keyString, KEY_MAX_LENGTH)) {
				throw new InvalidLengthException(keyString.length(), Utils.createErrorMessage(KEY_MAX_LENGTH));
			}
		}
		
		
	}

	/**
	 * use this method to generate json string of {@link GetConfigurationRequest}
	 * 
	 * @return string of {@link GetConfigurationRequest}
	 */
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
		log.debug(jsonString);
		return jsonString;
	}

}
