package com.vst.ocpp.testProtocol_1_6;

import com.vst.ocpp.exception.InvalidLengthException;
import com.vst.ocpp.util.Utils;

import lombok.Data;
import lombok.NoArgsConstructor;


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
	
	public KeyValueType(String key, Boolean readonly) {
		setKey(key);
		setReadonly(readonly);
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		
		if (!Utils.validate(key, STRING_50_CHAR_MAX_LENGTH)) {
			throw new InvalidLengthException(key.length(), Utils.createErrorMessage(STRING_50_CHAR_MAX_LENGTH));
		}
		this.key = key;
	}

	public Boolean getReadonly() {
		return readonly;
	}

	public void setReadonly(Boolean readonly) {
		this.readonly = readonly;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		if (value!=null) {
		if (!Utils.validate(value, STRING_500_CHAR_MAX_LENGTH)) {
			throw new InvalidLengthException(value.length(), Utils.createErrorMessage(STRING_500_CHAR_MAX_LENGTH));
		}
		}
		this.value = value;
	}

	
	  
	  
}
