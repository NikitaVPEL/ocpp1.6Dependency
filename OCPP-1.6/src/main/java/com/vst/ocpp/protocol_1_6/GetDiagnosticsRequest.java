package com.vst.ocpp.protocol_1_6;

import java.time.ZonedDateTime;
import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class GetDiagnosticsRequest {

	private String location;
	private Integer retries;
	private Integer retryInterval;
	private ZonedDateTime startTime;
	private ZonedDateTime stopTime;

	public GetDiagnosticsRequest(String location, Integer retries, Integer retryInterval, ZonedDateTime startTime,
			ZonedDateTime stopTime) {
		this(location);
		setRetries(retries);
		setRetryInterval(retryInterval);
		setStartTime(startTime);
		setStopTime(stopTime);
	}

	public GetDiagnosticsRequest(String location) {
		setLocation(location);
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getRetries() {
		return retries;
	}

	public void setRetries(Integer retries) {
		this.retries = retries;
	}

	public Integer getRetryInterval() {
		return retryInterval;
	}

	public void setRetryInterval(Integer retryInterval) {
		this.retryInterval = retryInterval;
	}

	public ZonedDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(ZonedDateTime startTime) {
		this.startTime = startTime;
	}

	public ZonedDateTime getStopTime() {
		return stopTime;
	}

	public void setStopTime(ZonedDateTime stopTime) {
		this.stopTime = stopTime;
	}

	public String toJson() {

		int messageType = 2;
		String messageIdKey = UUID.randomUUID().toString();

		JsonObject jsonObject = new JsonObject();

		jsonObject.addProperty("location", location);
		
		if (retries!=null) {
			jsonObject.addProperty("retries", retries);
		}
		if (retryInterval!=null) {
			jsonObject.addProperty("retryInterval", retryInterval);
		}
		if (startTime!=null) {
			jsonObject.addProperty("startTime", startTime.toString());
		}
		if (stopTime!=null) {
			jsonObject.addProperty("stopTime", stopTime.toString());
		}

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add("GetDiagnosticsRequest");
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		return jsonString;
	}

}
