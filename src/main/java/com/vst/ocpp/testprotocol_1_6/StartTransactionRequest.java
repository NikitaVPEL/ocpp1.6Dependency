package com.vst.ocpp.testprotocol_1_6;

import java.time.ZonedDateTime;
import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.exception.InvalidDataException;
import com.vst.ocpp.exception.InvalidLengthException;
import com.vst.ocpp.util.Utils;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/** Sent by the Charge Point to the Central System. */
@NoArgsConstructor
@Slf4j
public class StartTransactionRequest {

	private static final int IDTAG_MAX_LENGTH = 20;

	private Integer connectorId;
	private String idTag;
	private Integer meterStart;
	private Integer reservationId;
	private ZonedDateTime timestamp;

	/**
	 * Handle required fields.
	 *
	 * @param connectorId integer. value &gt; 0, see
	 *                    {@link #setConnectorId(Integer)}
	 * @param idTag       a String with max length 20, see {@link #setIdTag(String)}
	 * @param meterStart  integer, Wh at start, see {@link #setMeterStart(Integer)}
	 * @param timestamp   ZonedDateTime, start time, see
	 *                    {@link #setTimestamp(ZonedDateTime)}
	 */
	public StartTransactionRequest(Integer connectorId, String idTag, Integer meterStart, ZonedDateTime timestamp) {
		setConnectorId(connectorId);
		setIdTag(idTag);
		setMeterStart(meterStart);
		setTimestamp(timestamp);
	}

	public StartTransactionRequest(Integer connectorId, String idTag, Integer meterStart, Integer reservationId,
			ZonedDateTime timestamp) {
		this(connectorId, idTag, meterStart, timestamp);
		setReservationId(reservationId);
	}

	/**
	 * This identifies which connector of the Charge Point is used.
	 *
	 * @return connector.
	 */
	public Integer getConnectorId() {
		return connectorId;
	}

	/**
	 * Required. This identifies which connector of the Charge Point is used.
	 *
	 * @param connectorId integer. value &gt; 0
	 */
	public void setConnectorId(Integer connectorId) {
		if (connectorId == null || connectorId <= 0) {
			throw new InvalidDataException(connectorId, "connectorId must be greater or equal to 0");
		}
		this.connectorId = connectorId;
	}

	/**
	 * This contains the identifier for which a transaction has to be started.
	 *
	 * @return the IdToken.
	 */
	public String getIdTag() {
		return idTag;
	}

	/**
	 * Required. This contains the identifier for which a transaction has to be
	 * started.
	 *
	 * @param idTag a String with max length 20
	 */
	public void setIdTag(String idTag) {

		if (!Utils.validate(idTag, IDTAG_MAX_LENGTH)) {
			throw new InvalidLengthException(idTag.length(), Utils.createErrorMessage(IDTAG_MAX_LENGTH));
		}
		this.idTag = idTag;
	}

	/**
	 * This contains the meter value in Wh for the connector at start of the
	 * transaction.
	 *
	 * @return Wh at start.
	 */
	public Integer getMeterStart() {
		return meterStart;
	}

	/**
	 * Required. This contains the meter value in Wh for the connector at start of
	 * the transaction.
	 *
	 * @param meterStart integer, Wh at start.
	 */
	public void setMeterStart(Integer meterStart) {
		this.meterStart = meterStart;
	}

	/**
	 * This contains the id of the reservation that terminates as a result of this
	 * transaction.
	 *
	 * @return reservation.
	 */
	public Integer getReservationId() {
		return reservationId;
	}

	/**
	 * Optional. This contains the id of the reservation that terminates as a result
	 * of this transaction.
	 *
	 * @param reservationId integer, reservation.
	 */
	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}

	/**
	 * This contains the date and time on which the transaction is started.
	 *
	 * @return start time.
	 */
	public ZonedDateTime getTimestamp() {
		return timestamp;
	}

	/**
	 * Required. This contains the date and time on which the transaction is
	 * started.
	 *
	 * @param timestamp ZonedDateTime, start time.
	 */
	public void setTimestamp(ZonedDateTime timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * use this method to generate json string of {@link StartTransactionRequest}
	 * 
	 * @return string of {@link StartTransactionRequest}
	 */
	public String toJson() {

		int messageType = 2;
		String messageIdKey = UUID.randomUUID().toString();

		JsonObject jsonObject = new JsonObject();

		jsonObject.addProperty("connectorId", connectorId);
		jsonObject.addProperty("idTag", idTag);
		jsonObject.addProperty("meterStart", meterStart);

		if (reservationId != null) {
			jsonObject.addProperty("reservationId", reservationId);
		}

		jsonObject.addProperty("timestamp", timestamp.toString());

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add("StartTransaction");
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		log.debug(jsonString);
		return jsonString;
	}

}
