package com.vst.ocpp.protocol_1_6;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.NoArgsConstructor;
import java.util.UUID;
import java.time.ZonedDateTime;

@NoArgsConstructor
public class UpdateFirmwareRequest {
	private String location;
	private Integer retries;
	private ZonedDateTime retrieveDate;
	private Integer retryInterval;

	public UpdateFirmwareRequest(String location, Integer retries, ZonedDateTime retrieveDate, Integer retryInterval) {
		this(location, retrieveDate);
		setRetries(retries);
		setRetryInterval(retryInterval);
	}

	public UpdateFirmwareRequest(String location, ZonedDateTime retrieveDate) {
		setLocation(location);
		setRetrieveDate(retrieveDate);
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

	public ZonedDateTime getRetrieveDate() {
		return retrieveDate;
	}

	public void setRetrieveDate(ZonedDateTime retrieveDate) {
		this.retrieveDate = retrieveDate;
	}

	public Integer getRetryInterval() {
		return retryInterval;
	}

	public void setRetryInterval(Integer retryInterval) {
		this.retryInterval = retryInterval;
	}

	public String toJson() {
		int messageType = 2;
		String messageIdKey = UUID.randomUUID().toString();

		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("location", location);
		jsonObject.addProperty("retries", retries);
		jsonObject.addProperty("retrieveDate", retrieveDate.toString());
		jsonObject.addProperty("retryInterval", retryInterval);

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add("UpdateFirmware");
		jsonArray.add(jsonObject);

		return jsonArray.toString();
	}

}
