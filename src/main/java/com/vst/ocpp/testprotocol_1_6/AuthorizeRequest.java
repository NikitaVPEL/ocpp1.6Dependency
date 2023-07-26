package com.vst.ocpp.testprotocol_1_6;

import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.exception.InvalidLengthException;
import com.vst.ocpp.util.Utils;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/** Sent by the Charge Point to the Central System. */
@Slf4j
@NoArgsConstructor
public class AuthorizeRequest {

	private static final int ID_TAG_MAX_LENGTH = 20;

	private String idTag;

	public AuthorizeRequest(String idTag) {
		setIdTag(idTag);
	}

	public String getIdTag() {
		return idTag;
	}

	/**
	 * Required. This contains the identifier that needs to be authorized.
	 *
	 * @param idTag String, max 20 characters. Case insensitive.
	 */
	public void setIdTag(String idTag) {

		if (!Utils.validate(idTag, ID_TAG_MAX_LENGTH)) {
			throw new InvalidLengthException(idTag.length(), Utils.createErrorMessage(ID_TAG_MAX_LENGTH));
		}
		this.idTag = idTag;
	}

	/**
	 * use this method to generate json string of {@link AuthorizeRequest}
	 * 
	 * @return string of {@link AuthorizeRequest}
	 */
	public String toJson() {

		Integer messageType = 2;

		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("idTag", idTag);

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		//adding msg key using uuid random 
		jsonArray.add(UUID.randomUUID().toString());
		jsonArray.add("Authorize");
		jsonArray.add(jsonObject);
		
		String jsonString =jsonArray.toString();
		log.debug(jsonString);
		
		return jsonString; 
	}
}
