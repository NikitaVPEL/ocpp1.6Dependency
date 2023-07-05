package com.vst.ocpp.protocol_1_6;

import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.exception.InvalidLengthException;
import com.vst.ocpp.util.Utils;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DataTransferRequest {

	Utils utils = new Utils();

	private static final int VENDORID_MAX_LENGTH = 255;
	private static final int MESSAGEID_MAX_LENGTH = 50;

	private String vendorId;
	private String messageId;
	private String data;

	public DataTransferRequest(String vendorId) {
		setVendorId(vendorId);
	}

	public DataTransferRequest(String vendorId, String messageId, String data) {

		this(vendorId);
		setMessageId(messageId);
		setData(data);
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {

		if (vendorId!=null) {
		if (!utils.validate(vendorId, VENDORID_MAX_LENGTH)) {
			throw new InvalidLengthException(vendorId.length(), utils.createErrorMessage(VENDORID_MAX_LENGTH));
		}
		}
		this.vendorId = vendorId;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		
		if (messageId!=null) {
			if (!utils.validate(messageId, MESSAGEID_MAX_LENGTH)) {
			throw new InvalidLengthException(messageId.length(), utils.createErrorMessage(MESSAGEID_MAX_LENGTH));
		}
		}
		this.messageId = messageId;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String toJson() {

		int messageType = 2;
		String messageIdKey = UUID.randomUUID().toString();

		JsonObject jsonObject = new JsonObject();

		jsonObject.addProperty("vendorId", vendorId);

		if (messageId != null) {
			jsonObject.addProperty("messageId", messageId);
		}
		if (data != null) {
			jsonObject.addProperty("data", data);
		}

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add("DataTransfer");
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		return jsonString;
	}

}
