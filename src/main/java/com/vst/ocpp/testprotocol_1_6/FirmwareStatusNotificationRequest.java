package com.vst.ocpp.testprotocol_1_6;

import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/** Sent by the Charge Point to the Central System. */
@NoArgsConstructor
@Slf4j
public class FirmwareStatusNotificationRequest {

	private FirmwareStatus status;

	  /**
	   * Handle required fields.
	   *
	   * @param status Firmware status, see {@link #setStatus(FirmwareStatus)}.
	   */
	public FirmwareStatusNotificationRequest(FirmwareStatus status) {
		setStatus(status);
	}

	  /**
	   * This contains the status.
	   *
	   * @return connector.
	   */
	public FirmwareStatus getStatus() {
		return status;
	}

	  /**
	   * Required. This contains the identifier of the status.
	   *
	   * @param status {@link FirmwareStatus}
	   */
	public void setStatus(FirmwareStatus status) {
		this.status = status;
	}
	
	/**
	 * use this method to generate json string of {@link FirmwareStatusNotificationRequest}
	 * 
	 * @return string of {@link FirmwareStatusNotificationRequest}
	 */
	public String toJson() {
		
		Integer messageType = 2;
		String messageIdKey = UUID.randomUUID().toString();
		
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("status", status.toString());
		
		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add("FirmwareStatusNotification");
		jsonArray.add(jsonObject);
		
		String jsonString = jsonArray.toString();
		log.debug(jsonString);
		return jsonString;
	}
	
}
