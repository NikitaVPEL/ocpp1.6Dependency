package com.vst.ocpp.testprotocol_1_6;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.protocol_1_6.ClearCacheRequest;

/** Sent by the Charge Point to the Central System in response to a {@link ClearCacheRequest}. */
public class ClearCacheResponse {

	private ClearCacheStatusEnum status;
	private String messageIdKey;

	  /**
	   * Handle required fields.
	   *
	   * @param status the {@link ClearCacheStatusEnum}, see {@link #setStatus(ClearCacheStatusEnum)}
	   */
	public ClearCacheResponse(ClearCacheStatusEnum status, String messageIdKey) {
		setStatus(status);
		setMessageIdKey(messageIdKey);

	}

	  /**
	   * Accepted if the Charge Point has executed the request, otherwise rejected.
	   *
	   * @return the {@link ClearCacheStatusEnum}.
	   */
	public ClearCacheStatusEnum getStatus() {
		return status;
	}

	  /**
	   * Required. Accepted if the Charge Point has executed the request, otherwise rejected.
	   *
	   * @param status the {@link ClearCacheStatusEnum}.
	   */
	public void setStatus(ClearCacheStatusEnum status) {
		this.status = status;
	}

	public String getMessageIdKey() {
		return messageIdKey;
	}

	public void setMessageIdKey(String messageIdKey) {
		this.messageIdKey = messageIdKey;
	}

	public String toJson() {

		int messageType = 3;

		JsonObject jsonObject = new JsonObject();

		jsonObject.addProperty("status", status.toString());

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add(jsonObject);

		return jsonArray.toString();
	}

}
