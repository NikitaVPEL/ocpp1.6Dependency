package com.vst.ocpp.protocol_1_6;

import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.exception.InvalidLengthException;
import com.vst.ocpp.util.Utils;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Sent by Central System to Charge Point.
 *
 * <p>It is RECOMMENDED that the content and meaning of the 'key' and 'value' fields is agreed upon
 * between Charge Point and Central System.
 */
@NoArgsConstructor
@Slf4j
public class ChangeConfigurationRequest {

	private static final int KEY_MAX_LENGTH = 50;
	private static final int VALUE_MAX_LENGTH = 500;

	private String key;
	private String value;

	  /**
	   * Handle required fields.
	   *
	   * @param key String, max 50 characters, case insensitive, see {@link #setKey(String)}
	   * @param value String, max 500 characters, case insensitive, see {@link #setValue(String)}
	   */
	public ChangeConfigurationRequest(String key, String value) {
		setKey(key);
		setValue(value);
	}

	  /**
	   * The name of the configuration setting to change.
	   *
	   * @return Name of the configuration setting.
	   */
	public String getKey() {
		return key;
	}

	  /**
	   * Required. The name of the configuration setting to change.
	   *
	   * @param key String, max 50 characters, case insensitive.
	   */
	public void setKey(String key) {
		if (!Utils.validate(key, KEY_MAX_LENGTH)) {
			throw new InvalidLengthException(key.length(), Utils.createErrorMessage(KEY_MAX_LENGTH));
		}
		this.key = key;
	}

	  /**
	   * The new value as string for the setting.
	   *
	   * @return Value of the configuration setting.
	   */
	public String getValue() {
		return value;
	}

	  /**
	   * Required. The new value as string for the setting.
	   *
	   * @param value String, max 500 characters, case insensitive.
	   */
	public void setValue(String value) {
		if (!Utils.validate(value, VALUE_MAX_LENGTH)) {
			throw new InvalidLengthException(value.length(), Utils.createErrorMessage(VALUE_MAX_LENGTH));
		}
		this.value = value;
	}

	/**
	 * use this method to generate json string of {@link ChangeConfigurationRequest}
	 * 
	 * @return string of {@link ChangeConfigurationRequest}
	 */
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
		log.debug(jsonString);
		return jsonString;
	}
}
