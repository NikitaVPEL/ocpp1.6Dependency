package com.vst.ocpp.testprotocol_1_6;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.exception.InvalidDataException;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@Slf4j
public class GetLocalListVersionResponse {

	private Integer listVersion;
	String messageIdKey;

	/**
	 * Handle required fields.
	 *
	 * @param listVersion int, version of localAuthList, see
	 *                    {@link #setListVersion(Integer)}
	 */
	public GetLocalListVersionResponse(Integer listVersion, String messageIdKey) {
		setListVersion(listVersion);
		setMessageIdKey(messageIdKey);
	}

	/**
	 * This contains the current version number of the local authorization list in
	 * the Charge Point.
	 *
	 * @return String, version of localAuthList.
	 */
	public Integer getListVersion() {
		return listVersion;
	}

	/**
	 * Required. This contains the current version number of the local authorization
	 * list in the Charge Point.
	 *
	 * <p>
	 * A version number of 0 (zero) SHALL be used to indicate that the local
	 * authorization list is empty, and a version number of -1 SHALL be used to
	 * indicate that the Charge Point does not support Local Authorization Lists.
	 *
	 * @param listVersion int, version of localAuthList.
	 */
	public void setListVersion(Integer listVersion) {
		if (listVersion < -1) {
			throw new InvalidDataException(listVersion, "listVersion must be >= -1");
		}
		this.listVersion = listVersion;
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
	 * use this method to generate json string of
	 * {@link GetLocalListVersionResponse}
	 * 
	 * @return string of {@link GetLocalListVersionResponse}
	 */
	public String toJson() {

		Integer messageType = 3;

		JsonObject jsonObject = new JsonObject();

		jsonObject.addProperty("listVersion", listVersion);

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		log.debug(jsonString);
		return jsonString;
	}

}
