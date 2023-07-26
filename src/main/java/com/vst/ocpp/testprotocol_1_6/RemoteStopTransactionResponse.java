package com.vst.ocpp.testprotocol_1_6;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/** sent from Charge Point to Central System. */
@Slf4j
@NoArgsConstructor
public class RemoteStopTransactionResponse {

	private RemoteStartStopStatusEnum status;
	private String messageIdKey;

	/**
	 * Handle required fields.
	 *
	 * @param status the {@link RemoteStartStopStatusEnum}, see
	 *               {@link #setStatus(RemoteStartStopStatusEnum)}
	 */
	public RemoteStopTransactionResponse(RemoteStartStopStatusEnum status, String messageIdKey) {
		setStatus(status);
		setMessageIdKey(messageIdKey);

	}

	/**
	 * Status indicating whether Charge Point accepts the request to stop a
	 * transaction.
	 *
	 * @return the {@link RemoteStartStopStatusEnum}.
	 */
	public RemoteStartStopStatusEnum getStatus() {
		return status;
	}

	/**
	 * Required. Status indicating whether Charge Point accepts the request to stop
	 * a transaction.
	 *
	 * @param status the {@link RemoteStartStopStatusEnum}.
	 */
	public void setStatus(RemoteStartStopStatusEnum status) {
		this.status = status;
	}

	/**
	 * MessageIdKey indicating whether Charge Point returns the response to same message id key
	 */
	public String getMessageIdKey() {
		return messageIdKey;
	}

	/**
	 * MessageIdKey indicating whether Charge Point returns the response to same message id key
	 */
	public void setMessageIdKey(String messageIdKey) {
		this.messageIdKey = messageIdKey;
	}


	/**
	 * use this method to generate json string of {@link RemoteStopTransactionResponse}
	 * 
	 * @return string of {@link RemoteStopTransactionResponse}
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
		return jsonString;	}

}
