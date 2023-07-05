package com.vst.ocpp.protocol_1_6;

import java.time.ZonedDateTime;
import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.exception.InvalidLengthException;
import com.vst.ocpp.util.Utils;

public class ReserveNowRequest {

	Utils utils = new Utils();

	private static final int MAX_LENGTH = 20;

	private Integer connectorId;
	private ZonedDateTime expiryDate;
	private String idTag;
	private String parentIdTag;
	private Integer reservationId;

	public ReserveNowRequest(Integer connectorId, ZonedDateTime expiryDate, String idTag, String parentIdTag,
			Integer reservationId) {
		this(connectorId, expiryDate, parentIdTag, reservationId);
		setParentIdTag(parentIdTag);
	}

	public ReserveNowRequest(Integer connectorId, ZonedDateTime expiryDate, String idTag, Integer reservationId) {
		setConnectorId(connectorId);
		setExpiryDate(expiryDate);
		setIdTag(idTag);
		setReservationId(reservationId);
	}

	public Integer getConnectorId() {
		return connectorId;
	}

	public void setConnectorId(Integer connectorId) {
		this.connectorId = connectorId;
	}

	public ZonedDateTime getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(ZonedDateTime expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getIdTag() {
		return idTag;
	}

	public void setIdTag(String idTag) {

		if (!utils.validate(idTag, MAX_LENGTH)) {
			throw new InvalidLengthException(idTag.length(), utils.createErrorMessage(MAX_LENGTH));
		}
		this.idTag = idTag;
	}

	public String getParentIdTag() {
		return parentIdTag;
	}

	public void setParentIdTag(String parentIdTag) {
		if (!utils.validate(parentIdTag, MAX_LENGTH)) {
			throw new InvalidLengthException(parentIdTag.length(), utils.createErrorMessage(MAX_LENGTH));
		}
		this.parentIdTag = parentIdTag;
	}

	public Integer getReservationId() {
		return reservationId;
	}

	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}

	public String toJson() {

		int messageType = 2;
		String messageIdKey = UUID.randomUUID().toString();

		JsonObject jsonObject = new JsonObject();

		jsonObject.addProperty("connectorId", connectorId);
		jsonObject.addProperty("expiryDate", expiryDate.toString());
		jsonObject.addProperty("idTag", idTag);

		if (parentIdTag != null) {
			jsonObject.addProperty("parentIdTag", parentIdTag);

		}
		jsonObject.addProperty("reservationId", reservationId);

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add("ReserveNow");
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		return jsonString;
	}

}
