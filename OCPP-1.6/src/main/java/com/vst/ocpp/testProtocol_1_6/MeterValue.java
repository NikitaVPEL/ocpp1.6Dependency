package com.vst.ocpp.testProtocol_1_6;

import java.time.ZonedDateTime;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MeterValue {

	private ZonedDateTime timestamp;
	private SampledValue[] sampledValue;

	public MeterValue(ZonedDateTime timestamp, SampledValue[] sampledValue) {
		setTimestamp(timestamp);
		setSampledValue(sampledValue);
	}

	public ZonedDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(ZonedDateTime timestamp) {
		this.timestamp = timestamp;
	}

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

	public void setSampledValue(SampledValue[] sampledValue) {
		this.sampledValue = sampledValue;
	}

}
