package com.vst.ocpp.protocol_1_6;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.testprotocol_1_6.StopTransactionRequest;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Sent by the Central System to the Charge Point in response to a {@link StopTransactionRequest}.
 */
@Slf4j
@NoArgsConstructor
public class StopTransactionResponse {

	private IdTagInfo idTagInfo;
	private String messageIdKey;

	public StopTransactionResponse(IdTagInfo idTagInfo, String messageIdKey) {
		setIdTagInfo(idTagInfo);
		setMessageIdKey(messageIdKey);
	}

	  /**
	   * This contains information about authorization status, expiry and parent id. Null = transaction
	   * was stopped without an identifier.
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
	   * Optional. This contains information about authorization status, expiry and parent id. It is
	   * optional, because a transaction may have been stopped without an identifier.
	   *
	   * @param idTagInfo the {@link IdTagInfo}.
	   */
	public void setIdTagInfo(IdTagInfo idTagInfo) {
		this.idTagInfo = idTagInfo;
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
	 * @return string of {@link StopTransactionResponse}
	 */
	public String toJson() {

		int messageType = 3;

		JsonObject jsonObject = new JsonObject();

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
