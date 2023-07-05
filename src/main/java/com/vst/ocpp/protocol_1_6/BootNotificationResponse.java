package com.vst.ocpp.protocol_1_6;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class BootNotificationResponse {

	
	private ZonedDateTime dateTime;
	private Integer interval;
	private RegistrationStatus status;
	private String messageIdKey;
	
	public BootNotificationResponse(ZonedDateTime dateTime, int interval, RegistrationStatus status, String messageIdKey) {
		setDateTime(dateTime);
		setInterval(interval);
		setStatus(status);
		setMessageIdKey(messageIdKey);	
	}
	
	public String toJson() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		String currentTimeString = dateTime.format(formatter);
		int messageType = 3;
		
		status = RegistrationStatus.Accepted;
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("currentTime", currentTimeString);
		jsonObject.addProperty("interval", interval);
		jsonObject.addProperty("status", status.toString());

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		return jsonString;
	}
	
	
}
