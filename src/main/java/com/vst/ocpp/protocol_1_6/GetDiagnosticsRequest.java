package com.vst.ocpp.protocol_1_6;

import java.time.ZonedDateTime;
import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/** Sent by the the Central System to the Charge Point. */
@NoArgsConstructor
@Slf4j
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

	/**
	 * Handle required fields.
	 *
	 * @param location String, the destination folder, see
	 *                 {@link #setLocation(String)}
	 */
	public GetDiagnosticsRequest(String location) {
		setLocation(location);
	}

	/**
	 * This contains the location (directory) where the diagnostics file shall be
	 * uploaded to.
	 *
	 * @return String, the destination folder.
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Required. This contains the location (directory) where the diagnostics file
	 * shall be uploaded to.
	 *
	 * @param location String, the destination folder.
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * This specifies how many times Charge Point must try to upload the diagnostics
	 * before giving up. If this field is not present, it is left to Charge Point to
	 * decide how many times it wants to retry.
	 *
	 * @return int, minimum number of tries.
	 */
	public Integer getRetries() {
		return retries;
	}

	/**
	 * Optional. This specifies how many times Charge Point must try to upload the
	 * diagnostics before giving up. If this field is not present, it is left to
	 * Charge Point to decide how many times it wants to retry.
	 *
	 * @param retries int, minimum number of tries.
	 */
	public void setRetries(Integer retries) {
		if (retries != null) {
			this.retries = retries;
		}
	}

	/**
	 * The interval in seconds after which a retry may be attempted. If this field
	 * is not present, it is left to Charge Point to decide how long to wait between
	 * attempts.
	 *
	 * @return int, seconds
	 */
	public Integer getRetryInterval() {
		return retryInterval;
	}

	/**
	 * Optional. The interval in seconds after which a retry may be attempted. If
	 * this field is not present, it is left to Charge Point to decide how long to
	 * wait between attempts.
	 *
	 * @param retryInterval int, seconds
	 */
	public void setRetryInterval(Integer retryInterval) {
		if (retryInterval != null) {
			this.retryInterval = retryInterval;
		}
	}

	/**
	 * This contains the date and time of the oldest logging information to include
	 * in the diagnostics.
	 *
	 * @return ZonedDateTime, oldest log entry
	 */
	public ZonedDateTime getStartTime() {
		return startTime;
	}

	/**
	 * Optional. This contains the date and time of the oldest logging information
	 * to include in the diagnostics.
	 *
	 * @param startTime ZonedDateTime, oldest log entry
	 */
	public void setStartTime(ZonedDateTime startTime) {
		if (startTime != null) {
			this.startTime = startTime;
		}
	}

	/**
	 * This contains the date and time of the latest logging information to include
	 * in the diagnostics.
	 *
	 * @return ZonedDateTime, latest log entry
	 */
	public ZonedDateTime getStopTime() {
		return stopTime;
	}

	/**
	 * Optional. This contains the date and time of the latest logging information
	 * to include in the diagnostics.
	 *
	 * @param stopTime ZonedDateTime, latest log entry
	 */
	public void setStopTime(ZonedDateTime stopTime) {
		if (stopTime != null) {
			this.stopTime = stopTime;
		}
	}

	/**
	 * use this method to generate json string of {@link GetDiagnosticsRequest}
	 * 
	 * @return string of {@link GetDiagnosticsRequest}
	 */
	public String toJson() {

		int messageType = 2;
		String messageIdKey = UUID.randomUUID().toString();

		JsonObject jsonObject = new JsonObject();

		jsonObject.addProperty("location", location);

		if (retries != null) {
			jsonObject.addProperty("retries", retries);
		}
		if (retryInterval != null) {
			jsonObject.addProperty("retryInterval", retryInterval);
		}
		if (startTime != null) {
			jsonObject.addProperty("startTime", startTime.toString());
		}
		if (stopTime != null) {
			jsonObject.addProperty("stopTime", stopTime.toString());
		}

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add("GetDiagnosticsRequest");
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		log.debug(jsonString);
		return jsonString;
	}

}
