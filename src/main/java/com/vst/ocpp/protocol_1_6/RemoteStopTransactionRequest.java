package com.vst.ocpp.protocol_1_6;

import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/** Sent to Charge Point by Central System. */
@NoArgsConstructor
@Slf4j
@Data
public class RemoteStopTransactionRequest {

	private Integer transactionId;

	/**
	 * Handle required fields.
	 *
	 * @param transactionId integer, transaction id, see
	 *                      {@link #setTransactionId(Integer)}
	 */
	public RemoteStopTransactionRequest(Integer transactionId) {
		setTransactionId(transactionId);
	}

	/**
	 * use this method to generate json string of
	 * {@link RemoteStopTransactionRequest}
	 * 
	 * @return string of {@link RemoteStopTransactionRequest}
	 */
	public String toJson() {

		int messageType = 2;
		String messageIdKey = UUID.randomUUID().toString();

		JsonObject jsonObject = new JsonObject();

		jsonObject.addProperty("transactionId", transactionId);

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add("RemoteStopTransaction");
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		log.debug(jsonString);
		return jsonString;
	}

}
