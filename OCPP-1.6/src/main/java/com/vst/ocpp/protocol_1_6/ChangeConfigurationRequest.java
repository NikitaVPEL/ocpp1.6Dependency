package com.vst.ocpp.protocol_1_6;

import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.exception.InvalidLengthException;
import com.vst.ocpp.util.Utils;

public class ChangeConfigurationRequest {

	Utils utils = new Utils();
	private static final int KEY_MAX_LENGTH = 50;
	private static final int VALUE_MAX_LENGTH = 500;

	private String key;
	private String value;

	public ChangeConfigurationRequest(String key, String value) {
		setKey(key);
		setValue(value);
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		if (!utils.validate(key, KEY_MAX_LENGTH)) {
			throw new InvalidLengthException(key.length(), utils.createErrorMessage(KEY_MAX_LENGTH));
		}
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		if (!utils.validate(value, VALUE_MAX_LENGTH)) {
			throw new InvalidLengthException(value.length(), utils.createErrorMessage(VALUE_MAX_LENGTH));
		}
		this.value = value;
	}


	public String toJson() {

		int messageType = 2;
		String messageIdKey = UUID.randomUUID().toString();

		JsonObject jsonObject = new JsonObject();

		jsonObject.addProperty("key", key);
		jsonObject.addProperty("value", value);

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add("ChangeConfiguration");
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		return jsonString;
	}
}
