package com.vst.ocpp.testprotocol_1_6;

import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@Slf4j
public class DiagnosticsStatusNotificationRequest {

	private DiagnosticsStatus status;

	  /**
	   * Set required fields.
	   *
	   * @param status Diagnostics status, see {@link #setStatus(DiagnosticsStatus)}.
	   */
	public DiagnosticsStatusNotificationRequest(DiagnosticsStatus status) {
		setStatus(status);
	}

	 /**
	   * This contains the status.
	   *
	   * @return connector.
	   */
	public DiagnosticsStatus getStatus() {
		return status;
	}

	  /**
	   * Required. This contains the identifier of the status.
	   *
	   * @param status {@link DiagnosticsStatus}.
	   */
	public void setStatus(DiagnosticsStatus status) {
		this.status = status;
	}

	/**
	 * use this method to generate json string of {@link DiagnosticsStatusNotificationRequest}
	 * 
	 * @return string of {@link DiagnosticsStatusNotificationRequest}
	 */
	public String toJson() {

		int messageType = 2;
		String messageIdKey = UUID.randomUUID().toString();


		JsonObject jsonObject = new JsonObject();

		jsonObject.addProperty("status", status.toString());

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add("DiagnosticsStatusNotification");
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		log.debug(jsonString);
		return jsonString;
	}



}
