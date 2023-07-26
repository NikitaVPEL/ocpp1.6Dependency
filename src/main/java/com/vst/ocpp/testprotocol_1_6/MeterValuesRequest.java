package com.vst.ocpp.testprotocol_1_6;

import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Sent by the Charge Point to the Central System.
 *
 * @see MeterValue
 */
@NoArgsConstructor
@Slf4j
public class MeterValuesRequest {

	private Integer connectorId;
	private Integer transactionId;
	private MeterValue[] meterValue;

	public MeterValuesRequest(Integer connectorId, Integer transactionId, MeterValue[] meterValue) {
		this(connectorId, meterValue);
		setTransactionId(transactionId);
	}

	/**
	 * Handle required fields.
	 *
	 * @param connectorId integer, connector, see {@link #setConnectorId(Integer)}
	 */
	public MeterValuesRequest(Integer connectorId, MeterValue[] meterValue) {
		setConnectorId(connectorId);
		setMeterValue(meterValue);
	}

	/**
	 * This contains a number (&gt;0) designating a connector of the Charge Point.
	 * ‘0’ (zero) is used to designate the main power meter.
	 *
	 * @return Connector
	 */
	public Integer getConnectorId() {
		return connectorId;
	}

	/**
	 * Required. This contains a number (&gt;0) designating a connector of the
	 * Charge Point. ‘0’ (zero) is used to designate the main power meter.
	 *
	 * @param connectorId integer, connector
	 */
	public void setConnectorId(Integer connectorId) {
		this.connectorId = connectorId;
	}

	/**
	 * The transaction to which these meter samples are related.
	 *
	 * @return transaction id.
	 */
	public Integer getTransactionId() {
		return transactionId;
	}

	/**
	 * Optional. The transaction to which these meter samples are related.
	 *
	 * @param transactionId integer, transaction id.
	 */
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * The sampled meter values with timestamps.
	 *
	 * @return Array of {@link MeterValue}.
	 */
	public JsonArray getMeterValue() {

		JsonArray jsonArray = new JsonArray();

		for (MeterValue value : meterValue) {

			JsonObject jsonObject = new JsonObject();

			jsonObject.addProperty("timestamp", value.getTimestamp().toString());
			jsonObject.add("sampledValue", value.getSampledValue());

			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}

	/**
	 * Required. The sampled meter values with timestamps.
	 *
	 * @param meterValue Array of {@link MeterValue}.
	 */
	public void setMeterValue(MeterValue[] meterValue) {
		this.meterValue = meterValue;
	}


	/**
	 * use this method to generate json string of {@link MeterValuesRequest}
	 * 
	 * @return string of {@link MeterValuesRequest}
	 */
	public String toJson() {

		Integer messageType = 2;
		String messageIdKey = UUID.randomUUID().toString();

		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("connectorId", connectorId);

		if (transactionId != null) {
			jsonObject.addProperty("transactionId", transactionId);
		}

		jsonObject.add("meterValue", getMeterValue());

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add("MeterValues");
		jsonArray.add(jsonObject);
		
		String jsonString = jsonArray.toString();
		log.debug(jsonString);
		return jsonString;
	}

}
