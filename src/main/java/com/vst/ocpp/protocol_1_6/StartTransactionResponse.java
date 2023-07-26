package com.vst.ocpp.protocol_1_6;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.testprotocol_1_6.StartTransactionRequest;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Sent by the Central System to the Charge Point in response to a {@link StartTransactionRequest}.
 */
@Slf4j
@NoArgsConstructor
public class StartTransactionResponse {

	private IdTagInfo idTagInfo;
	private Integer transactionId;
	private String messageIdKey;

	  /**
	   * Handle required fields.
	   *
	   * @param idTagInfo the {@link IdTagInfo}, see {@link #setIdTagInfo(IdTagInfo)}
	   * @param transactionId integer, transaction, see {@link #setTransactionId(Integer)}
	   */
	public StartTransactionResponse(IdTagInfo idTagInfo, Integer transactionId, String messageIdKey) {
		setIdTagInfo(idTagInfo);
		setTransactionId(transactionId);
		setMessageIdKey(messageIdKey);
	}

	  /**
	   * This contains information about authorization status, expiry and parent id.
	   *
	   * @return the {@link IdTagInfo}.
	   */
	public JsonObject getIdTagInfo() {
		
		JsonObject idTagInfoObject = new JsonObject();

		// have to decide about this
		if (idTagInfo.getExpiryDate() != null) {
			idTagInfoObject.addProperty("expiryDate", idTagInfo.getExpiryDate().toString());
		}

		if (idTagInfo.getParentIdTag() != null) {
			idTagInfoObject.addProperty("parentIdTag", idTagInfo.getParentIdTag());
		}
			idTagInfoObject.addProperty("status", idTagInfo.getStatus().toString());
			
			return idTagInfoObject;
	}
	  /**
	   * Required. This contains information about authorization status, expiry and parent id.
	   *
	   * @param idTagInfo the {@link IdTagInfo}.
	   */
	public void setIdTagInfo(IdTagInfo idTagInfo) {
		this.idTagInfo = idTagInfo;
	}

	  /**
	   * This contains the transaction id supplied by the Central System.
	   *
	   * @return transaction id.
	   */
	public Integer getTransactionId() {
		return transactionId;
	}
	  /**
	   * Required. This contains the transaction id supplied by the Central System.
	   *
	   * @param transactionId integer, transaction.
	   */
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
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
	 * use this method to generate json string
	 * 
	 * @return string of {@link StartTransactionResponse}
	 */
	public String toJson() {

		int messageType = 3;

		JsonObject jsonObject = new JsonObject();

		jsonObject.addProperty("transactionId", transactionId);
		jsonObject.add("idTagInfo", getIdTagInfo());

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		log.debug(jsonString);
		return jsonString;
	}

}
