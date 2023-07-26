package com.vst.ocpp.protocol_1_6;

import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.exception.InvalidLengthException;
import com.vst.ocpp.util.Utils;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/** Sent either by the Central System to the Charge Point or vice versa. */
@NoArgsConstructor
@Slf4j
public class DataTransferRequest {

	private static final int VENDORID_MAX_LENGTH = 255;
	private static final int MESSAGEID_MAX_LENGTH = 50;

	private String vendorId;
	private String messageId;
	private String data;

	/**
	 * Handle required fields.
	 *
	 * @param vendorId Vendor identification, see {@link #setVendorId(String)}.
	 */
	public DataTransferRequest(String vendorId) {
		setVendorId(vendorId);
	}

	public DataTransferRequest(String vendorId, String messageId, String data) {

		this(vendorId);
		setMessageId(messageId);
		setData(data);
	}

	/**
	 * This identifies the Vendor specific implementation.
	 *
	 * @return String, Vendor identification.
	 */
	public String getVendorId() {
		return vendorId;
	}

	/**
	 * Required. This identifies the Vendor specific implementation.
	 *
	 * @param vendorId String, max 255 characters, case insensitive.
	 */
	public void setVendorId(String vendorId) {

		if (vendorId != null) {
			if (!Utils.validate(vendorId, VENDORID_MAX_LENGTH)) {
				throw new InvalidLengthException(vendorId.length(), Utils.createErrorMessage(VENDORID_MAX_LENGTH));
			}
			this.vendorId = vendorId;
		}
	}

	/**
	 * Additional identification field.
	 *
	 * @return Additional identification.
	 */
	public String getMessageId() {
		return messageId;
	}

	/**
	 * Optional. Additional identification field.
	 *
	 * @param messageId String, max 50 characters, case insensitive.
	 */
	public void setMessageId(String messageId) {

		if (messageId != null) {
			if (!Utils.validate(messageId, MESSAGEID_MAX_LENGTH)) {
				throw new InvalidLengthException(messageId.length(), Utils.createErrorMessage(MESSAGEID_MAX_LENGTH));
			}
			this.messageId = messageId;
		}
	}

	/**
	 * Data without specified length or format.
	 *
	 * @return data.
	 */
	public String getData() {
		return data;
	}

	/**
	 * Optional. Data without specified length or format.
	 *
	 * @param data String, data.
	 */
	public void setData(String data) {
		if (data != null) {
			this.data = data;
		}
	}

	/**
	 * use this method to generate json string of {@link DataTransferRequest}
	 * 
	 * @return string of {@link DataTransferRequest}
	 */
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
		log.debug(jsonString);
		return jsonString;
	}

}
