package com.vst.ocpp.testProtocol_1_6;

import java.util.Iterator;
import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MeterValuesRequest {

	private Integer connectorId;
	private Integer transactionId;
	private MeterValue[] meterValue;

	public MeterValuesRequest(Integer connectorId, Integer transactionId, MeterValue[] meterValue) {
		this(connectorId, meterValue);
		setTransactionId(transactionId);
	}

	public MeterValuesRequest(Integer connectorId, MeterValue[] meterValue) {
		setConnectorId(connectorId);
		setMeterValue(meterValue);
	}

	public Integer getConnectorId() {
		return connectorId;
	}

	public void setConnectorId(Integer connectorId) {
		this.connectorId = connectorId;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

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

	public void setMeterValue(MeterValue[] meterValue) {
		this.meterValue = meterValue;
	}

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
		
		return jsonArray.toString();

	}

}
