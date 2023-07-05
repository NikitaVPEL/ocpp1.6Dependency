package com.vst.ocpp.testProtocol_1_6;

import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class FirmwareStatusNotificationRequest {

	private FirmwareStatus status;

	public FirmwareStatusNotificationRequest(FirmwareStatus status) {
		setStatus(status);
	}

	public FirmwareStatus getStatus() {
		return status;
	}

	public void setStatus(FirmwareStatus status) {
		this.status = status;
	}
	
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
		
		return jsonArray.toString();
	}
	
}
