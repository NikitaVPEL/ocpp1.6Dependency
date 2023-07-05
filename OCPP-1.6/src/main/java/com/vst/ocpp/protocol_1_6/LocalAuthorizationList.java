package com.vst.ocpp.protocol_1_6;

import com.google.gson.JsonObject;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LocalAuthorizationList {

	private String idTag;
	private IdTagInfo idTagInfo;

	public LocalAuthorizationList(String idTag) {
		setIdTag(idTag);
	}

	public LocalAuthorizationList(String idTag, IdTagInfo idTagInfo) {
		this(idTag);
		setIdTagInfo(idTagInfo);
	}

	public String getIdTag() {
		return idTag;
	}

	public void setIdTag(String idTag) {
		this.idTag = idTag;
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

}
