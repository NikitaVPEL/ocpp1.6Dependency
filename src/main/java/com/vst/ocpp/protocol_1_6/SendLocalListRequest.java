package com.vst.ocpp.protocol_1_6;

import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SendLocalListRequest {

	private Integer listVersion;
	private LocalAuthorizationList localAuthorizationList;
	private UpdateType updateType;

	public SendLocalListRequest(Integer listVersion, LocalAuthorizationList localAuthorizationList,
			UpdateType updateType) {
		this(listVersion, updateType);
		setLocalAuthorizationList(localAuthorizationList);
	}

	public SendLocalListRequest(Integer listVersion, UpdateType updateType) {
		setListVersion(listVersion);
		setUpdateType(updateType);
	}

	public Integer getListVersion() {
		return listVersion;
	}

	public void setListVersion(Integer listVersion) {
		this.listVersion = listVersion;
	}

	public JsonObject getLocalAuthorizationList() {

		JsonObject jsonObject = new JsonObject();

		// have to decide about this
		jsonObject.addProperty("idTag", localAuthorizationList.getIdTag());

		if (localAuthorizationList.getIdTagInfo() != null) {
			jsonObject.add("idTagInfo", localAuthorizationList.getIdTagInfo());
		}

		return jsonObject;
	}

	public void setLocalAuthorizationList(LocalAuthorizationList localAuthorizationList) {
		this.localAuthorizationList = localAuthorizationList;
	}

	public UpdateType getUpdateType() {
		return updateType;
	}

	public void setUpdateType(UpdateType updateType) {
		this.updateType = updateType;
	}

	public String toJson() {

		int messageType = 2;
		String messageIdKey = UUID.randomUUID().toString();

		JsonObject jsonObject = new JsonObject();

		jsonObject.addProperty("listVersion", listVersion);

		if (localAuthorizationList != null) {
			jsonObject.add("localAuthorizationList", getLocalAuthorizationList());
		}

		jsonObject.addProperty("updateType", updateType.toString());

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add("sendLocalListRequest");
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		return jsonString;
	}

}
