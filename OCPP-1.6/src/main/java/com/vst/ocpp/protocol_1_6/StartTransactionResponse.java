package com.vst.ocpp.protocol_1_6;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class StartTransactionResponse {

	private IdTagInfo idTagInfo;
	private Integer transactionId;
	private String messageIdKey;

	public StartTransactionResponse(IdTagInfo idTagInfo, Integer transactionId, String messageIdKey) {
		setIdTagInfo(idTagInfo);
		setTransactionId(transactionId);
		setMessageIdKey(messageIdKey);
	}

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

	public void setIdTagInfo(IdTagInfo idTagInfo) {
		this.idTagInfo = idTagInfo;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
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

		jsonObject.addProperty("transactionId", transactionId);
		jsonObject.add("idTagInfo", getIdTagInfo());

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		return jsonString;
	}

}
