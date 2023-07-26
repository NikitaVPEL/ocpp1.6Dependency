package com.vst.ocpp.protocol_1_6;

import java.time.ZonedDateTime;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@NoArgsConstructor
@Slf4j
public class HeartbeatResponse {

	private ZonedDateTime dateTime;
	private String messageIdKey;

	/**
	 * Handle required fields.
	 *
	 * @param currentTime ZonedDateTime, current time, see
	 *                    {@link #setCurrentTime(ZonedDateTime)}
	 */
	public HeartbeatResponse(ZonedDateTime dateTime, String messageIdKey) {
		setDateTime(dateTime);
		setMessageIdKey(messageIdKey);
	}

	/**
	 * use this method to generate json string of {@link HeartbeatResponse}
	 * 
	 * @return string of {@link HeartbeatResponse}
	 */
	public String toJson() {

		int messageType = 3;

		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("currentTime", dateTime.toString());

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		log.debug(jsonString);
		return jsonString;
	}

}
