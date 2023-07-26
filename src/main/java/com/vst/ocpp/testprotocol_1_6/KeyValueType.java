package com.vst.ocpp.testprotocol_1_6;

import com.vst.ocpp.exception.InvalidDataException;
import com.vst.ocpp.exception.InvalidLengthException;
import com.vst.ocpp.protocol_1_6.ChangeConfigurationRequest;
import com.vst.ocpp.util.Utils;

import lombok.NoArgsConstructor;

/**
 * Contains information about a specific configuration key. It is returned in
 * {@link GetConfigurationResponse}.
 */
@NoArgsConstructor
public class KeyValueType {

	private static final int STRING_50_CHAR_MAX_LENGTH = 50;
	private static final int STRING_500_CHAR_MAX_LENGTH = 500;

	private String key;
	private Boolean readonly;
	private String value;

	public KeyValueType(String key, Boolean readonly, String value) {
		this(key, readonly);
		setValue(value);
	}

	/**
	 * Handle required fields.
	 *
	 * @param key      String, max 50 characters, case insensitive, see
	 *                 {@link #setKey(String)}
	 * @param readonly Boolean, configuration is read only, see
	 *                 {@link #setReadonly(Boolean)}
	 */
	public KeyValueType(String key, Boolean readonly) {
		setKey(key);
		setReadonly(readonly);
	}

	/**
	 * Name of the key.
	 *
	 * @return key.
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Required. Name of the key.
	 *
	 * @param key String, max 50 characters, case insensitive.
	 */
	public void setKey(String key) {

		if (!Utils.validate(key, STRING_50_CHAR_MAX_LENGTH)) {
			throw new InvalidLengthException(key.length(), Utils.createErrorMessage(STRING_50_CHAR_MAX_LENGTH));
		}
		this.key = key;
	}

	/**
	 * False if the value can be set with a {@link ChangeConfigurationRequest}.
	 *
	 * @return Is configuration read only.
	 */
	public Boolean getReadonly() {
		return readonly;
	}

	/**
	 * Required. False if the value can be set with a
	 * {@link ChangeConfigurationRequest}.
	 *
	 * @param readonly Boolean, configuration is read only.
	 */
	public void setReadonly(Boolean readonly) {
		if (readonly == null) {
			throw new InvalidDataException(null, "readonly must be present");
		}
		this.readonly = readonly;
	}

	/**
	 * If key is known but not set, this field may be absent.
	 *
	 * @return Value associated to the key.
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Optional. If key is known but not set, this field may be absent.
	 *
	 * @param value String, max 500 characters, case insensitive.
	 */
	public void setValue(String value) {
		if (value != null) {
			if (!Utils.validate(value, STRING_500_CHAR_MAX_LENGTH)) {
				throw new InvalidLengthException(value.length(), Utils.createErrorMessage(STRING_500_CHAR_MAX_LENGTH));
			}
			this.value = value;
		}
	}

}
