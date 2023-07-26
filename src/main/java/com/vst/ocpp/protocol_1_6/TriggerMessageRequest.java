package com.vst.ocpp.protocol_1_6;

import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vst.ocpp.exception.InvalidDataException;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Sent by the Central System to the Charge Point.
 */
@Slf4j
@NoArgsConstructor
public class TriggerMessageRequest {

	private Integer connectorId;
	private TriggerMessageRequestType requestedMessage;

	public TriggerMessageRequest(Integer connectorId, TriggerMessageRequestType requestedMessage) {
		this(requestedMessage);
		setConnectorId(connectorId);

	}

	/**
	 * Handle required fields.
	 *
	 * @param triggerMessageRequestType {@link TriggerMessageRequestType}, see
	 *                                  {@link #setRequestedMessage(TriggerMessageRequestType)}
	 */
	public TriggerMessageRequest(TriggerMessageRequestType requestedMessage) {
		setRequestedMessage(requestedMessage);
	}

	/**
	 * This identifies which connector of the Charge Point is used.
	 *
	 * @return connector.
	 */
	public Integer getConnectorId() {
		return connectorId;
	}

	/**
	 * Optional. This identifies which connector of the Charge Point is used.
	 *
	 * @param connectorId integer. value &gt; 0
	 */
	public void setConnectorId(Integer connectorId) {
		if (connectorId != null) {

			if (connectorId <= 0) {
				throw new InvalidDataException(connectorId, "connectorId must be > 0");
			}
			this.connectorId = connectorId;
		}
	}

	public TriggerMessageRequestType getRequestedMessage() {
		return requestedMessage;
	}

	/**
	 * Required. This identifies which type of message you want to trigger.
	 *
	 * @param requestedMessage {@link TriggerMessageRequestType}.
	 */
	public void setRequestedMessage(TriggerMessageRequestType requestedMessage) {
		this.requestedMessage = requestedMessage;
	}

	/**
	 * use this method to generate json string
	 * 
	 * @return string of {@link TriggerMessageRequest}
	 */
	public String toJson() {
		int messageType = 2;
		String messageIdKey = UUID.randomUUID().toString();

		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("connectorId", connectorId);
		jsonObject.addProperty("requestedMessage", requestedMessage.toString());

		JsonArray jsonArray = new JsonArray();
		jsonArray.add(messageType);
		jsonArray.add(messageIdKey);
		jsonArray.add("TriggerMessage");
		jsonArray.add(jsonObject);

		String jsonString = jsonArray.toString();
		log.debug(jsonString);
		return jsonString;
	}
}
