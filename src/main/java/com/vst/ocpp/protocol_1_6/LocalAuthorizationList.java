package com.vst.ocpp.protocol_1_6;

import com.google.gson.JsonObject;
import com.vst.ocpp.exception.InvalidLengthException;
import com.vst.ocpp.util.Utils;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LocalAuthorizationList {

	private String idTag;
	private IdTagInfo idTagInfo;

	/**
	 * Handle required fields.
	 *
	 * @param idTag String, the idTag, see {@link #setIdTag(String)}
	 */
	public LocalAuthorizationList(String idTag) {
		setIdTag(idTag);
	}

	public LocalAuthorizationList(String idTag, IdTagInfo idTagInfo) {
		this(idTag);
		setIdTagInfo(idTagInfo);
	}

	/**
	 * The identifier to which this authorization applies
	 *
	 * @return String the idTag
	 */
	public String getIdTag() {
		return idTag;
	}

	/**
	 * Required. The identifier to which this authorization applies
	 *
	 * @param idTag String, the idTag
	 */
	public void setIdTag(String idTag) {
		if (!Utils.validate(idTag, 20)) {
			throw new InvalidLengthException(idTag.length(), Utils.createErrorMessage(20));
		}
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
