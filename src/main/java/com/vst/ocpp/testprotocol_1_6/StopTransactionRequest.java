package com.vst.ocpp.testprotocol_1_6;

import java.time.ZonedDateTime;
import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.exception.InvalidLengthException;
import com.vst.ocpp.util.Utils;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/** Sent by the Charge Point to the Central System. */
@NoArgsConstructor
@Slf4j
public class StopTransactionRequest {

	private static final int IDTAG_MAX_LENGTH = 20;

	private String idTag;
	private Integer meterStop;
	private ZonedDateTime timestamp;
	private Integer transactionId;
	private Reason reason;
	private MeterValue[] transactionData;

	public StopTransactionRequest(String idTag, Integer meterStop, ZonedDateTime timestamp, Integer transactionId,
			Reason reason, MeterValue[] transactionData) {
		this(meterStop, timestamp, transactionId);
		setIdTag(idTag);
		setReason(reason);
		setTransactionData(transactionData);

	}

	/**
	 * Handle required fields.
	 *
	 * @param meterStop     integer, meter value in Wh, see
	 *                      {@link #setMeterStop(Integer)}
	 * @param timestamp     ZonedDateTime, stop time, see
	 *                      {@link #setTimestamp(ZonedDateTime)}
	 * @param transactionId integer, transaction id, see
	 *                      {@link #setTransactionId(Integer)}
	 */
	public StopTransactionRequest(Integer meterStop, ZonedDateTime timestamp, Integer transactionId) {
		setMeterStop(meterStop);
		setTimestamp(timestamp);
		setTransactionId(transactionId);
	}

	/**
	 * This contains the identifier which requested to stop the charging.
	 *
	 * @return the IdToken.
	 */
	public String getIdTag() {
		return idTag;
	}

	/**
	 * Optional. This contains the identifier which requested to stop the charging.
	 * It is optional because a Charge Point may terminate charging without the
	 * presence of an idTag, e.g. in case of a reset. A Charge Point SHALL send the
	 * idTag if known.
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
	 * This contains the meter value in Wh for the connector at end of the
	 * transaction.
	 *
	 * @return meter value in Wh.
	 */
	public Integer getMeterStop() {
		return meterStop;
	}

	/**
	 * Required. This contains the meter value in Wh for the connector at end of the
	 * transaction.
	 *
	 * @param meterStop integer, meter value in Wh.
	 */
	public void setMeterStop(Integer meterStop) {
		this.meterStop = meterStop;
	}

	/**
	 * This contains the date and time on which the transaction is stopped.
	 *
	 * @return stop time.
	 */
	public ZonedDateTime getTimestamp() {
		return timestamp;
	}

	/**
	 * Required. This contains the date and time on which the transaction is
	 * stopped.
	 *
	 * @param timestamp ZonedDateTime, stop time.
	 */
	public void setTimestamp(ZonedDateTime timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * This contains the transaction-id as received by the
	 * {@link StartTransactionConfirmation}.
	 *
	 * @return transaction id.
	 */
	public Integer getTransactionId() {
		return transactionId;
	}

	/**
	 * Required. This contains the transaction-id as received by the
	 * {@link StartTransactionConfirmation}.
	 *
	 * @param transactionId integer, transaction id.
	 */
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * This contains the reason why the transaction was stopped.
	 *
	 * @return the {@link Reason}.
	 */
	public Reason getReason() {
		return reason;
	}

	/**
	 * Optional. This contains the reason why the transaction was stopped. MAY only
	 * be omitted when the {@link Reason} is "Local".
	 *
	 * @param reason the {@link Reason}.
	 */
	public void setReason(Reason reason) {
		this.reason = reason;
	}

	/**
	 * This contains transaction usage details relevant for billing purposes.
	 *
	 * @return the {@link MeterValue}.
	 */
	public JsonArray getTransactionData() {
		JsonArray jsonArray = new JsonArray();
		if (transactionData != null) {

			for (MeterValue value : transactionData) {

				JsonObject jsonObject = new JsonObject();

				jsonObject.addProperty("timestamp", value.getTimestamp().toString());
				jsonObject.add("sampledValue", value.getSampledValue());

				jsonArray.add(jsonObject);
			}
		}
		return jsonArray;
	}

	/**
	 * Optional. This contains transaction usage details relevant for billing
	 * purposes.
	 *
	 * @param transactionData the {@link MeterValue}.
	 */
	public void setTransactionData(MeterValue[] transactionData) {
		this.transactionData = transactionData;
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

		if (idTag != null) {
			jsonObject.addProperty("idTag", idTag);
		}
		jsonObject.addProperty("meterStop", meterStop);
		jsonObject.addProperty("timestamp", timestamp.toString());
		jsonObject.addProperty("transactionId", transactionId);

		if (reason != null) {
			jsonObject.addProperty("reason", reason.toString());
		}
		if (transactionData != null) {
			jsonObject.add("transactionData", getTransactionData());
		}

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add("StopTransaction");
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		log.debug(jsonString);
		return jsonString;
	}

}
