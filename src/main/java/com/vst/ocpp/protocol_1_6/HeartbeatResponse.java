package com.vst.ocpp.protocol_1_6;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class HeartbeatResponse {

	private LocalDateTime dateTime;
	private String messageIdKey;

	public HeartbeatResponse(LocalDateTime dateTime, String messageIdKey) {
		setDateTime(dateTime);
		setMessageIdKey(messageIdKey);
	}

	public String toJson() {

		int messageType = 3;

		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("currentTime", dateTime.toString());

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		return jsonString;
	}

}
