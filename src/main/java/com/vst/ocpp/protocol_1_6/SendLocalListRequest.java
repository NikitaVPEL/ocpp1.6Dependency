package com.vst.ocpp.protocol_1_6;

import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.exception.InvalidDataException;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@Slf4j
public class SendLocalListRequest {

	private Integer listVersion;
	private LocalAuthorizationList[] localAuthorizationList;
	private UpdateType updateType;

	public SendLocalListRequest(Integer listVersion, LocalAuthorizationList[] localAuthorizationList,
			UpdateType updateType) {
		this(listVersion, updateType);
		setLocalAuthorizationList(localAuthorizationList);
	}

	/**
	 * Handle required fields.
	 *
	 * @param listVersion, the version number of the list, see
	 *                     {@link #setListVersion(Integer)}
	 * @param updateType,  {@link UpdateType}}, see
	 *                     {@link #setUpdateType(UpdateType)}
	 */
	public SendLocalListRequest(Integer listVersion, UpdateType updateType) {
		setListVersion(listVersion);
		setUpdateType(updateType);
	}

	/**
	 * In case of a full update this is the version number of the full list. In case
	 * of a differential update it is the version number of the list after the
	 * update has been applied.
	 *
	 * @return Integer, the version number of the list
	 */
	public Integer getListVersion() {
		return listVersion;
	}

	/**
	 * Required. In case of a full update this is the version number of the full
	 * list. In case of a differential update it is the version number of the list
	 * after the update has been applied.
	 *
	 * @param listVersion, the version number of the list
	 */
	public void setListVersion(Integer listVersion) {
		if (listVersion < 0) {
			throw new InvalidDataException(listVersion, "listVersion must be >= 0");
		}
		this.listVersion = listVersion;
	}

	/**
	 * In case of a full update this contains the list of values that form the new
	 * local authorization list. In case of a differential update it contains the
	 * changes to be applied to the local authorization list in the Charge Point.
	 *
	 * @return Array of {@link AuthorizationData}
	 */
	public JsonArray getLocalAuthorizationList() {

		JsonArray jsonArray = new JsonArray();
		if (localAuthorizationList != null) {
			for (LocalAuthorizationList list : localAuthorizationList) {

				JsonObject jsonObject = new JsonObject();

				// have to decide about this
				jsonObject.addProperty("idTag", list.getIdTag());

				if (list.getIdTagInfo() != null) {
					jsonObject.add("idTagInfo", list.getIdTagInfo());
				}
				jsonArray.add(jsonObject);
			}
		}
		return jsonArray;
	}

	/**
	 * Optional. In case of a full update this contains the list of values that form
	 * the new local authorization list. In case of a differential update it
	 * contains the changes to be applied to the local authorization list in the
	 * Charge Point.
	 *
	 * @param localAuthorizationList, Array of {@link AuthorizationData}
	 */
	public void setLocalAuthorizationList(LocalAuthorizationList[] localAuthorizationList) {
		if (localAuthorizationList != null) {
			this.localAuthorizationList = localAuthorizationList;
		}
	}

	/**
	 * Required. This contains the type of update (full or differential) of this
	 * request.
	 *
	 * @return {@link UpdateType}
	 */
	public UpdateType getUpdateType() {
		return updateType;
	}

	/**
	 * Required. This contains the type of update (full or differential) of this
	 * request.
	 *
	 * @param updateType, {@link UpdateType}}
	 */
	public void setUpdateType(UpdateType updateType) {
		this.updateType = updateType;
	}

	/**
	 * use this method to generate json string
	 * 
	 * @return string of {@link SendLocalListRequest}
	 */
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
		log.debug(jsonString);
		return jsonString;
	}

}
