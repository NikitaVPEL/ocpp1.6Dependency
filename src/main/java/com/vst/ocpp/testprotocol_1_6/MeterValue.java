package com.vst.ocpp.testprotocol_1_6;

import java.time.ZonedDateTime;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.NoArgsConstructor;

/**
 * Collection of one or more sampled values in {@link MeterValuesRequest}. All
 * {@link SampledValue} in a {@link MeterValue} are sampled at the same point in
 * time.
 */
@NoArgsConstructor
public class MeterValue {

	private ZonedDateTime timestamp;
	private SampledValue[] sampledValue;

	/**
	 * Handle required fields.
	 *
	 * @param timestamp    {@link ZonedDateTime} timestamp, see
	 *                     {@link #setTimestamp(ZonedDateTime)}
	 * @param sampledValue Array of {@link SampledValue}, see
	 *                     {@link #setSampledValue(SampledValue[])}
	 */
	public MeterValue(ZonedDateTime timestamp, SampledValue[] sampledValue) {
		setTimestamp(timestamp);
		setSampledValue(sampledValue);
	}

	/**
	 * Timestamp for measured value(s).
	 *
	 * @return original timestamp.
	 */
	public ZonedDateTime getTimestamp() {
		return timestamp;
	}

	/**
	 * Required. Timestamp for measured value(s).
	 *
	 * @param timestamp {@link ZonedDateTime} timestamp
	 */
	public void setTimestamp(ZonedDateTime timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * One or more measured values.
	 *
	 * @return Array of {@link SampledValue}.
	 */
	public JsonArray getSampledValue() {

		JsonArray jsonArray = new JsonArray();

		for (SampledValue sampledString : sampledValue) {

			JsonObject jsonObject = new JsonObject();

			jsonObject.addProperty("value", sampledString.getValue());

			if (sampledString.getContext() != null) {
				jsonObject.addProperty("context", sampledString.getContext());
			}
			if (sampledString.getFormat() != null) {
				jsonObject.addProperty("format", sampledString.getFormat().toString());
			}
			if (sampledString.getMeasurand() != null) {
				jsonObject.addProperty("measurand", sampledString.getMeasurand());
			}
			if (sampledString.getPhase() != null) {
				jsonObject.addProperty("phase", sampledString.getPhase());
			}
			if (sampledString.getLocation() != null) {
				jsonObject.addProperty("location", sampledString.getLocation().toString());
			}
			if (sampledString.getUnit() != null) {
				jsonObject.addProperty("unit", sampledString.getUnit().toString());
			}

			jsonArray.add(jsonObject);
		}
		return jsonArray;

	}

	/**
	 * Required. One or more measured values.
	 *
	 * @param sampledValue Array of {@link SampledValue}.
	 */
	public void setSampledValue(SampledValue[] sampledValue) {
		this.sampledValue = sampledValue;
	}

}
