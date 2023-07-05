package com.vst.ocpp.testProtocol_1_6;

import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class DiagnosticsStatusNotificationRequest {

	private DiagnosticsStatus status;

	public DiagnosticsStatusNotificationRequest(DiagnosticsStatus status) {
		setStatus(status);
	}

	public DiagnosticsStatus getStatus() {
		return status;
	}

	public void setStatus(DiagnosticsStatus status) {
		this.status = status;
	}


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

		return jsonArray.toString();
	}



}
