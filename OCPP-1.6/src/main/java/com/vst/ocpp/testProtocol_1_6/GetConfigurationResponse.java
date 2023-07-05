package com.vst.ocpp.testProtocol_1_6;

import java.util.Iterator;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.exception.InvalidLengthException;
import com.vst.ocpp.util.Utils;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class GetConfigurationResponse {

	private static final int STRING_50_CHAR_MAX_LENGTH = 50;

	private KeyValueType[] configurationKey;
	private String[] unknownKey;
	private String messageIdKey;

	public GetConfigurationResponse(KeyValueType[] configurationKey, String[] unknownKey, String messageIdKey) {
		this(messageIdKey);
		setConfigurationKey(configurationKey);
		setUnknownKey(unknownKey);
	}

	public GetConfigurationResponse(String messageIdKey) {
		setMessageIdKey(messageIdKey);
	}

	public JsonArray getConfigurationKey() {

		JsonArray jsonArray = new JsonArray();
		if (configurationKey != null) {

			for (KeyValueType keyValueType : configurationKey) {

				JsonObject jsonObject = new JsonObject();

				jsonObject.addProperty("key", keyValueType.getKey());
				jsonObject.addProperty("readonly", keyValueType.getReadonly());

				if (keyValueType.getValue() != null) {
					jsonObject.addProperty("value", keyValueType.getValue());
				}
				jsonArray.add(jsonObject);
			}
		}
		return jsonArray;
	}

	public void setConfigurationKey(KeyValueType[] configurationKey) {
		this.configurationKey = configurationKey;
	}

	public JsonArray getUnknownKey() {

		JsonArray jsonArray = new JsonArray();

		if (unknownKey != null) {
			for (String key : unknownKey) {
				if (!Utils.validate(key, STRING_50_CHAR_MAX_LENGTH)) {
					throw new InvalidLengthException(unknownKey.length,
							Utils.createErrorMessage(STRING_50_CHAR_MAX_LENGTH));
				}
				jsonArray.add(key);
			}
		}
		return jsonArray;
	}

	public void setUnknownKey(String[] unknownKey) {

		this.unknownKey = unknownKey;
	}

	public String getMessageIdKey() {
		return messageIdKey;
	}

	public void setMessageIdKey(String messageIdKey) {
		this.messageIdKey = messageIdKey;
	}

	public String toJson() {

		Integer messageType = 3;

		JsonObject jsonObject = new JsonObject();

		if (configurationKey != null) {
			jsonObject.add("configurationKey", getConfigurationKey());
		}

		if (unknownKey != null) {
			jsonObject.add("unknownKey", getUnknownKey());
		}

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add(jsonObject);

		return jsonArray.toString();
	}

}
