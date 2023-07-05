package com.vst.ocpp.testProtocol_1_6;

import java.util.UUID;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;
import org.hibernate.id.UUIDGenerationStrategy;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.exception.InvalidLengthException;
import com.vst.ocpp.util.Utils;

public class AuthorizeRequest {

	Utils utils = new Utils();
	private static final int ID_TAG_MAX_LENGTH = 20;
	
	private String idTag;

	public AuthorizeRequest(String idTag) {
		setIdTag(idTag);
	}

	public String getIdTag() {
		return idTag;
	}

	public void setIdTag(String idTag) {
		
		if (!utils.validate(idTag, ID_TAG_MAX_LENGTH)) {
			throw new InvalidLengthException(idTag.length(), utils.createErrorMessage(ID_TAG_MAX_LENGTH));
		}
		this.idTag = idTag;
	}

	public String toJson() {

		Integer messageType = 2;
		String messageIdKey = UUID.randomUUID().toString();

		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("idTag", idTag);

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add("Authorize");
		jsonArray.add(jsonObject);

		return jsonArray.toString();
	}
}
