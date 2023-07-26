package com.vst.ocpp.testprotocol_1_6;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.exception.InvalidDataException;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@Slf4j
public class SendLocalListResponse {

	private UpdateStatusEnum status;
	private String messageIdKey;

	/**
	 * Handle required fields.
	 *
	 * @param status {@link UpdateStatusEnum}, status of localAuthList updating, see
	 *               {@link #setStatus(UpdateStatusEnum)}
	 */
	public SendLocalListResponse(UpdateStatusEnum status, String messageIdKey) {
		setStatus(status);
		setMessageIdKey(messageIdKey);

	}

	/**
	 * This indicates whether the Charge Point has successfully received and applied
	 * the update of the local authorization list.
	 *
	 * @return UpdateStatusEnum, status of localAuthList updating.
	 */
	public UpdateStatusEnum getStatus() {
		return status;
	}

	/**
	 * Required. This indicates whether the Charge Point has successfully received
	 * and applied the update of the local authorization list.
	 *
	 * @param status {@link UpdateStatus}, status of localAuthList updating.
	 */
	public void setStatus(UpdateStatusEnum status) {
		if (status == null) {
			throw new InvalidDataException(null, "updateStatus must be present");
		}
		this.status = status;
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
	 * use this method to generate json string of {@link UpdateStatusEnum}
	 * 
	 * @return string of {@link UpdateStatusEnum}
	 */
	public String toJson() {

		int messageType = 3;

		JsonObject jsonObject = new JsonObject();

		jsonObject.addProperty("status", status.toString());

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		log.debug(jsonString);
		return jsonString;
	}

}
