package com.vst.ocpp.protocol_1_6;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Sent by the Charge Point to the Central System or vice versa in response to a {@link
 * DataTransferRequest}.
 */
@NoArgsConstructor
@Slf4j
public class DataTransferResponse {

	private DataTransferStatus status;
	private String data;
	private String messageIdKey;

	public DataTransferResponse(DataTransferStatus status, String messageIdKey) {
		setStatus(status);
		setMessageIdKey(messageIdKey);
	}

	  /**
	   * Handle required fields.
	   *
	   * @param status the {@link DataTransferStatus}, see {@link #setStatus(DataTransferStatus)}
	   */
	public DataTransferResponse(DataTransferStatus status, String data, String messageIdKey) {
		this(status, messageIdKey);
		setData(data);
	}

	  /**
	   * This indicates the success or failure of the data transfer.
	   *
	   * @return the {@link DataTransferStatus}.
	   */
	public DataTransferStatus getStatus() {
		return status;
	}

	  /**
	   * Required. This indicates the success or failure of the data transfer.
	   *
	   * @param status the {@link DataTransferStatus}.
	   */
	public void setStatus(DataTransferStatus status) {
		this.status = status;
	}

	 /**
	   * Optional. Data in response to request.
	   *
	   * @return data.
	   */
	public String getData() {
		return data;
	}

	  /**
	   * Optional. Data in response to request.
	   *
	   * @param data String, data
	   */
	public void setData(String data) {
		this.data = data;
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
	 * use this method to generate json string of {@link DataTransferResponse}
	 * 
	 * @return string of {@link DataTransferResponse}
	 */
	public String toJson() {

		int messageType = 3;

		JsonObject jsonObject = new JsonObject();

		jsonObject.addProperty("status", status.toString());
		
		if (data!=null) {
			jsonObject.addProperty("data", data);
		}

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		log.debug(jsonString);
		return jsonString;
	}

}
