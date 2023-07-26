package com.vst.ocpp.protocol_1_6;

import java.time.ZonedDateTime;
import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.exception.InvalidDataException;
import com.vst.ocpp.exception.InvalidLengthException;
import com.vst.ocpp.util.Utils;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/** Sent to Charge Point by Central System. */
@NoArgsConstructor
@Slf4j
public class ReserveNowRequest {

	private static final int MAX_LENGTH = 20;

	private Integer connectorId;
	private ZonedDateTime expiryDate;
	private String idTag;
	private String parentIdTag;
	private Integer reservationId;

	public ReserveNowRequest(Integer connectorId, ZonedDateTime expiryDate, String idTag, String parentIdTag,
			Integer reservationId) {
		this(connectorId, expiryDate, idTag, reservationId);
		setParentIdTag(parentIdTag);
	}

	/**
	 * Handle required fields.
	 *
	 * @param connectorId   Integer, the destination connectorId, see
	 *                      {@link #setConnectorId(Integer)}
	 * @param expiryDate    ZonedDateTime, end of reservation, see
	 *                      {@link #setExpiryDate(ZonedDateTime)}
	 * @param idTag         String, the identifier, see {@link #setIdTag(String)}
	 * @param reservationId Integer, id of reservation, see
	 *                      {@link #setReservationId(Integer)}
	 */
	public ReserveNowRequest(Integer connectorId, ZonedDateTime expiryDate, String idTag, Integer reservationId) {
		setConnectorId(connectorId);
		setExpiryDate(expiryDate);
		setIdTag(idTag);
		setReservationId(reservationId);
	}

	/**
	 * This contains the id of the connector to be reserved. A value of 0 means that
	 * the reservation is not for a specific connector.
	 *
	 * @return Integer, the destination connectorId.
	 */
	public Integer getConnectorId() {
		return connectorId;
	}

	/**
	 * Required. This contains the id of the connector to be reserved. A value of 0
	 * means that the reservation is not for a specific connector.
	 *
	 * @param connectorId Integer, the destination connectorId.
	 */
	public void setConnectorId(Integer connectorId) {
		if (connectorId < 0) {
			throw new InvalidDataException(connectorId, "connectorId must be >= 0");
		}
		this.connectorId = connectorId;
	}

	/**
	 * This contains the date and time when the reservation ends.
	 *
	 * @return ZonedDateTime, end of reservation.
	 */
	public ZonedDateTime getExpiryDate() {
		return expiryDate;
	}

	/**
	 * Required. This contains the date and time when the reservation ends.
	 *
	 * @param expiryDate ZonedDateTime, end of reservation.
	 */
	public void setExpiryDate(ZonedDateTime expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * The identifier for which the Charge Point has to reserve a connector.
	 *
	 * @return String, the identifier.
	 */
	public String getIdTag() {
		return idTag;
	}

	/**
	 * Required. The identifier for which the Charge Point has to reserve a
	 * connector.
	 *
	 * @param idTag String, the identifier.
	 */
	public void setIdTag(String idTag) {

		if (!Utils.validate(idTag, MAX_LENGTH)) {
			throw new InvalidLengthException(idTag.length(), Utils.createErrorMessage(MAX_LENGTH));
		}
		this.idTag = idTag;
	}

	/**
	 * The parent idTag.
	 *
	 * @return String, the parent identifier.
	 */
	public String getParentIdTag() {
		return parentIdTag;
	}

	/**
	 * Optional. The parent idTag.
	 *
	 * @param parentIdTag String, the parent identifier.
	 */
	public void setParentIdTag(String parentIdTag) {
		if (parentIdTag != null) {

			if (!Utils.validate(parentIdTag, MAX_LENGTH)) {
				throw new InvalidLengthException(parentIdTag.length(), Utils.createErrorMessage(MAX_LENGTH));
			}
			this.parentIdTag = parentIdTag;
		}
	}

	/**
	 * Unique id for this reservation.
	 *
	 * @return Integer, id of reservation.
	 */
	public Integer getReservationId() {
		return reservationId;
	}

	/**
	 * Required. Unique id for this reservation.
	 *
	 * @param reservationId Integer, id of reservation.
	 */
	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}

	/**
	 * use this method to generate json string of {@link ReserveNowRequest}
	 * 
	 * @return string of {@link ReserveNowRequest}
	 */
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
		log.debug(jsonString);
		return jsonString;
	}

}
