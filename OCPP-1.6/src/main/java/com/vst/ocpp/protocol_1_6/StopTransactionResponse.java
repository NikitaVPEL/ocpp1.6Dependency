package com.vst.ocpp.protocol_1_6;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class StopTransactionResponse {

	private IdTagInfo idTagInfo;
	private String messageIdKey;

	public StopTransactionResponse(IdTagInfo idTagInfo, String messageIdKey) {
		setIdTagInfo(idTagInfo);
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

	public String getMessageIdKey() {
		return messageIdKey;
	}

	public void setMessageIdKey(String messageIdKey) {
		this.messageIdKey = messageIdKey;
	}

	public String toJson() {

		int messageType = 3;

		JsonObject jsonObject = new JsonObject();

		jsonObject.add("idTagInfo", getIdTagInfo());

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		return jsonString;
	}

}
