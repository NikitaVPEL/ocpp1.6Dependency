package com.vst.ocpp.protocol_1_6;

import java.time.ZonedDateTime;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.exception.InvalidDataException;
import com.vst.ocpp.testprotocol_1_6.BootNotificationRequest;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Sent by the Central System to the Charge Point in response to a
 * {@link BootNotificationRequest}.
 *
 * @see BootNotificationRequest
 */
@Slf4j
@NoArgsConstructor
public class BootNotificationResponse {

	private ZonedDateTime dateTime;
	private Integer interval;
	private RegistrationStatus status;
	private String messageIdKey;

	/**
	 * Handle required fields.
	 *
	 * @param currentTime Central System’s current time, see
	 *                    {@link #setCurrentTime(ZonedDateTime)}
	 * @param interval    heartbeat/delay interval in seconds. Min value 0, see
	 *                    {@link #setInterval(Integer)}
	 * @param status      Charge Points registration status, see
	 *                    {@link #setStatus(RegistrationStatus)}
	 */

	public BootNotificationResponse(ZonedDateTime dateTime, int interval, RegistrationStatus status,
			String messageIdKey) {
		setDateTime(dateTime);
		setInterval(interval);
		setStatus(status);
		setMessageIdKey(messageIdKey);
	}

	/**
	 * Central System's current time.
	 *
	 * @return an instance of {@link ZonedDateTime}.
	 */
	public ZonedDateTime getDateTime() {
		return dateTime;
	}

	/**
	 * Required. This contains the Central System’s current time.
	 *
	 * @param currentTime Central System’s current time.
	 */
	public void setDateTime(ZonedDateTime dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * When RegistrationStatus is Accepted, this contains the heartbeat interval in
	 * seconds. If the Central System returns something other than Accepted, the
	 * value of the interval field indicates the minimum wait time before sending a
	 * next BootNotification request.
	 *
	 * @return Heartbeat/delay interval in seconds.
	 */
	public Integer getInterval() {
		return interval;
	}

	/**
	 * Required. When RegistrationStatus is Accepted, this contains the heartbeat
	 * interval in seconds. If the Central System returns something other than
	 * Accepted, the value of the interval field indicates the minimum wait time
	 * before sending a next BootNotification request.
	 *
	 * @param interval heartbeat/delay interval in seconds. Min value 0.
	 */
	public void setInterval(Integer interval) {
		if (interval < 0) {
			throw new InvalidDataException(interval, "interval be a positive value");
		}
		this.interval = interval;
	}

	/**
	 * This contains whether the Charge Point has been registered within the System
	 * Central.
	 *
	 * @return Charge Points registration status as {@link RegistrationStatus}.
	 */
	public RegistrationStatus getStatus() {
		return status;
	}

	/**
	 * Required. This contains whether the Charge Point has been registered within
	 * the System Central.
	 *
	 * @param status Charge Points registration status.
	 */
	public void setStatus(RegistrationStatus status) {
		this.status = status;
	}

	/**
	 * MessageIdKey indicating whether Charge Point returns the response to same message id key
	 */
	public String getMessageIdKey() {
		return messageIdKey;
	}

	/**
	 * MessageIdKey indicating whether Charge Point returns the response to same message id key
	 */
	public void setMessageIdKey(String messageIdKey) {
		this.messageIdKey = messageIdKey;
	}

	/**
	 * use this method to generate json string
	 * 
	 * @return string of {@link BootNotificationRequest}
	 */
	public String toJson() {

		int messageType = 3;

		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("currentTime", dateTime.toString());
		jsonObject.addProperty("interval", interval);
		jsonObject.addProperty("status", status.toString());

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		log.debug(jsonString);
		return jsonString;
	}

}
