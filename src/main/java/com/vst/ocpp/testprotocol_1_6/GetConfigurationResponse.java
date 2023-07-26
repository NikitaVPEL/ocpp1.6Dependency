package com.vst.ocpp.testprotocol_1_6;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.exception.InvalidLengthException;
import com.vst.ocpp.protocol_1_6.GetConfigurationRequest;
import com.vst.ocpp.util.Utils;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Sent by Charge Point the to the Central System in response to a
 * {@link GetConfigurationRequest}.
 */
@Slf4j
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

	/**
	 * List of requested or known keys.
	 *
	 * @return Array of {@link KeyValueType}.
	 */
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

	/**
	 * Optional. List of requested or known keys.
	 *
	 * @param configurationKey Array of {@link KeyValueType}.
	 */
	public void setConfigurationKey(KeyValueType[] configurationKey) {
		this.configurationKey = configurationKey;
	}

	/**
	 * Requested keys that are unknown.
	 *
	 * @return Array of key names.
	 */
	public JsonArray getUnknownKey() {

		JsonArray jsonArray = new JsonArray();

		if (unknownKey != null) {
			for (String key : unknownKey) {
				jsonArray.add(key);
			}
		}
		return jsonArray;
	}

	/**
	 * Optional. Requested keys that are unknown.
	 *
	 * @param unknownKey Array of String, max 50 characters, case insensitive.
	 */
	public void setUnknownKey(String[] unknownKey) {

		if (unknownKey != null) {
			for (String key : unknownKey) {
				if (!Utils.validate(key, STRING_50_CHAR_MAX_LENGTH)) {
					throw new InvalidLengthException(key.length(), Utils.createErrorMessage(STRING_50_CHAR_MAX_LENGTH));
				}
			}
			this.unknownKey = unknownKey;
		}
	}

	/**
	 * MessageIdKey indicating whether Charge Point returns the response to same
	 * message id key
	 */
	public String getMessageIdKey() {
		return messageIdKey;
	}

	/**
	 * MessageIdKey indicating whether Charge Point returns the response to same
	 * message id key
	 */
	public void setMessageIdKey(String messageIdKey) {
		this.messageIdKey = messageIdKey;
	}

	/**
	 * use this method to generate json string of {@link GetConfigurationResponse}
	 * 
	 * @return string of {@link GetConfigurationResponse}
	 */
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

		String jsonString = jsonArray.toString();
		log.debug(jsonString);
		return jsonString;
	}

}
