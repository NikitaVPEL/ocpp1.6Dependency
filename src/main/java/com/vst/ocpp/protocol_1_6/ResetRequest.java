package com.vst.ocpp.protocol_1_6;

import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/** Sent to Charge Point by Central System. */
@NoArgsConstructor
@Slf4j
public class ResetRequest {

	private ResetType type;

	/**
	 * Handle required fields.
	 *
	 * @param type the {@link ResetType}, see {@link #setType(ResetType)}
	 */
	public ResetRequest(ResetType type) {
		setType(type);
	}

	/**
	 * This contains the type of reset that the Charge Point should perform.
	 *
	 * @return the {@link ResetType}.
	 */
	public ResetType getType() {
		return type;
	}

	/**
	 * Required. This contains the type of reset that the Charge Point should
	 * perform.
	 *
	 * @param type the {@link ResetType}.
	 */
	public void setType(ResetType type) {
		this.type = type;
	}

	/**
	 * use this method to generate json string of {@link ResetRequest}
	 * 
	 * @return string of {@link ResetRequest}
	 */
	public String toJson() {

		int messageType = 2;
		String messageIdKey = UUID.randomUUID().toString();

		JsonArray jsonArray = new JsonArray();

		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("type", type.toString());

		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add("Reset");
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		log.debug(jsonString);
		return jsonString;

	}
}
