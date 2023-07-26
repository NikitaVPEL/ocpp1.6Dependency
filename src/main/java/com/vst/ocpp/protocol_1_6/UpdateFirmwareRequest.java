package com.vst.ocpp.protocol_1_6;

import java.time.ZonedDateTime;
import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/** Sent by the Central System to the Charge Point. */
@Slf4j
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

	/**
	 * Handle required fields.
	 *
	 * @param location     String, a URI with the firmware, see
	 *                     {@link #setLocation(String)}
	 * @param retrieveDate ZonedDateTime, date and time of retrieving, see
	 *                     {@link #setRetrieveDate(ZonedDateTime)}
	 */
	public UpdateFirmwareRequest(String location, ZonedDateTime retrieveDate) {
		setLocation(location);
		setRetrieveDate(retrieveDate);
	}

	/**
	 * This contains a string containing a URI pointing to a location from which to
	 * retrieve the firmware.
	 *
	 * @return String, a URI with the firmware.
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Required. This contains a string containing a URI pointing to a location from
	 * which to retrieve the firmware.
	 *
	 * @param location String, a URI with the firmware.
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * This specifies how many times Charge Point must try to download the firmware
	 * before giving up. If this field is not present, it is left to Charge Point to
	 * decide how many times it wants to retry.
	 *
	 * @return int, retry times.
	 */
	public Integer getRetries() {
		return retries;
	}

	/**
	 * Optional. This specifies how many times Charge Point must try to download the
	 * firmware before giving up. If this field is not present, it is left to Charge
	 * Point to decide how many times it wants to retry.
	 *
	 * @param retries int, retry times.
	 */
	public void setRetries(Integer retries) {
		this.retries = retries;
	}

	/**
	 * This contains the date and time after which the Charge Point must retrieve
	 * the (new) firmware.
	 *
	 * @return ZonedDateTime, date and time of retrieving.
	 */
	public ZonedDateTime getRetrieveDate() {
		return retrieveDate;
	}

	/**
	 * Required. This contains the date and time after which the Charge Point must
	 * retrieve the (new) firmware.
	 *
	 * @param retrieveDate ZonedDateTime, date and time of retrieving.
	 */
	public void setRetrieveDate(ZonedDateTime retrieveDate) {
		this.retrieveDate = retrieveDate;
	}

	/**
	 * The interval in seconds after which a retry may be attempted. If this field
	 * is not present, it is left to Charge Point to decide how long to wait between
	 * attempts.
	 *
	 * @return int, retry interval.
	 */
	public Integer getRetryInterval() {
		return retryInterval;
	}

	/**
	 * Optional. The interval in seconds after which a retry may be attempted. If
	 * this field is not present, it is left to Charge Point to decide how long to
	 * wait between attempts.
	 *
	 * @param retryInterval int, retry interval.
	 */
	public void setRetryInterval(Integer retryInterval) {
		this.retryInterval = retryInterval;
	}

	/**
	 * use this method to generate json string
	 * 
	 * @return string of {@link UpdateFirmwareRequest}
	 */
	public String toJson() {
		int messageType = 2;
		String messageIdKey = UUID.randomUUID().toString();

		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("location", location);
		if (retries != null) {
			jsonObject.addProperty("retries", retries);
		}
		jsonObject.addProperty("retrieveDate", retrieveDate.toString());
		
		if (retryInterval != null) {
			jsonObject.addProperty("retryInterval", retryInterval);
		}

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add("UpdateFirmware");
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		log.debug(jsonString);
		return jsonString;
	}

}
